package com.codeyourbest.itraveller.domain.idm.repositories;

import com.codeyourbest.itraveller.domain.idm.persistance.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {
}
