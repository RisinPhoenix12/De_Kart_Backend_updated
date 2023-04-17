package com.deloitte.mockProj.backend.Repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.mockProj.backend.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, BigInteger> {
	
	@Query(value = "SELECT * FROM USER WHERE username = ?1", nativeQuery = true)
	User findByUsername(String username);
	
	@Query(value = "SELECT count(user_id) from user", nativeQuery = true)
	int findTotalUsers();
}
