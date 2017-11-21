package com.codeyourbest.itraveller.domain.search;

import com.codeyourbest.itraveller.domain.search.persistance.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ConnectionRepository extends JpaRepository<Connection,Long> {
}
