package com.ex.AngHibBank.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ex.AngHibBank.model.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,Integer> {
	public Optional<User> findByUsername(String username);
}
