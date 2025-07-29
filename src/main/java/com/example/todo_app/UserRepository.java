package com.example.todo_app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
		User findByEmail(String email); // Custom query to find user by mail
		User findByUsername(String username); //Custom query to find user by username
}