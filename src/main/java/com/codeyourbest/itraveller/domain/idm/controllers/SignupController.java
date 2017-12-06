package com.codeyourbest.itraveller.domain.idm.controllers;


import com.codeyourbest.itraveller.domain.idm.persistance.User;
import com.codeyourbest.itraveller.domain.idm.pub.SignupForm;
import com.codeyourbest.itraveller.domain.idm.pub.UserUtils;
import com.codeyourbest.itraveller.domain.idm.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@Controller
public class SignupController {


    public static final String SIGNUP_URL_MAPPING = "/signup";
    public static final String REGISTRATION_FORM_NAME = "signupForm";
    public static final String SUBSCRIPTION_VIEW_NAME = "user/signup";
    public static final String EMAIL_ALREADY_EXISTS = "duplicatedEmail";
    public static final String MESSAGE = "message";

    private static final Logger LOG = LoggerFactory.getLogger(SignupController.class);
    private static final String SIGNED_UP_MESSAGE_KEY = "signedUp";

    @Autowired
    UserRepository userRepository;

    @GetMapping(SIGNUP_URL_MAPPING)
    public String signupGet(ModelMap model){
        model.addAttribute(REGISTRATION_FORM_NAME, new SignupForm());
        return SUBSCRIPTION_VIEW_NAME;
    }

    @PostMapping(SIGNUP_URL_MAPPING)
    public String signupPost(@ModelAttribute("signupForm") @Validated SignupForm signupForm, BindingResult bindingResult, ModelMap model) {

        if (bindingResult.hasErrors()){
            LOG.debug("User passed invalid parameters durind registration: " + bindingResult.getAllErrors());
            model.addAttribute(SIGNED_UP_MESSAGE_KEY, "false");
            if (bindingResult.getErrorCount() > 1) {
                model.addAttribute(MESSAGE, "Invalid arguments");
            } else {
                model.addAttribute(MESSAGE, "Invalid argument");
            }
            return SUBSCRIPTION_VIEW_NAME;
        }

        if (userRepository.findByEmail(signupForm.getEmail()) != null) {
            model.addAttribute(SIGNED_UP_MESSAGE_KEY, "false");
            model.addAttribute(EMAIL_ALREADY_EXISTS, "Email already exists");
            model.addAttribute(MESSAGE, "Email already exists");
            return SUBSCRIPTION_VIEW_NAME;
        }

        User user = UserUtils.createUserFromForm(signupForm);
        userRepository.save(user);

        // Auto logins the registered user
        Authentication auth = new UsernamePasswordAuthenticationToken(
                user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

        model.addAttribute(SIGNED_UP_MESSAGE_KEY, "true");
        return "redirect:/?registrationSuccess";
    }
}
