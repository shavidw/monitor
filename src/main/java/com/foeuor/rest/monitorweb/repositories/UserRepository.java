package com.foeuor.rest.monitorweb.repositories;

import java.util.List;

import org.hibernate.secure.internal.JaccSecurityListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foeuor.rest.monitorweb.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	boolean existsByUsername(String username);
	
	boolean existsByUsernameAndPassword(String username, String password);
	
	List<User> findUsersByIsAvailable(boolean isAvailable);
}	
