package com.codeyourbest.itraveller.search.connection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ConnectionRepository extends JpaRepository<Connection,Long> {
}
