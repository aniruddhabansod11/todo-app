package com.example.todo_app;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Username should not be blank!")
	@Size(min = 3, max = 20, message = "Username must be between 3 to 20 characters.")
	@Column(unique = true)
	private String username;
	
	@NotBlank(message = "Email required!")
	@Email(message = "Email must be valid.")
	@Column(unique = true)
	private String email;
	
	@NotBlank(message = "Password is required.")
	@Size(min = 5, message = "Password must contain minimun 5 characters.")
	private String password;
	
	@NotBlank(message = "Full name is required.")
	private String fullName;
	
	public User(){}
	
	public User(String username, String email, String password, String fullName) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
	}	
		public Long getId() {return id;}
		public void setId(Long id) {this.id = id;}
		
		public String getUsername() {return username;}
		public void setUsername(String username) {this.username = username;}
		
		public String getEmail() {return email;} 
		public void setRmail(String email) {this.email = email;}
		
		public String getPassword() {return password;} 
		public void setEmail(String password) {this.password = password;}
		
		public String getFullName() {return fullName;} 
		public void setFullName(String fullName) {this.fullName= fullName;}	
}