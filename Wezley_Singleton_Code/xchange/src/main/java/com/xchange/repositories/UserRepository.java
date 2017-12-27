package com.xchange.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xchange.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
	
	@Modifying
	@Query("UPDATE User u SET u = :updated WHERE u.userId = :userId")
	public User updateUserById(@Param("userId") Long userId, @Param("updated") User updatedUser);
	
}
