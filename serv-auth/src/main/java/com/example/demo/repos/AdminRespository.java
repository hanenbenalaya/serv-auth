package com.example.demo.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Admin;

@RepositoryRestResource
public interface AdminRespository extends JpaRepository<Admin, Long> {

	
	Optional<Admin> findByemail(@Param("email") String email);

}
