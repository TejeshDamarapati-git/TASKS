package com.mayuratech.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mayuratech.api.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailOrUserName(String username, String Email);
	
//	User getUser(String username);
	boolean existsByEmail(String Email);
	boolean existsByUserName(String username);

}
