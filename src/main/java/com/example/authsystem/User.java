package com.example.authsystem;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String pwd1;
    private String pwd2;
    private String pwd3;
    private String email;

    // Getters and setters
    
    
    
    public Long getId() { return id; }
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setId(Long id) { this.id = id; }
    public String getPwd1() { return pwd1; }
    public void setPwd1(String pwd1) { this.pwd1 = pwd1; }
    public String getPwd2() { return pwd2; }
    public void setPwd2(String pwd2) { this.pwd2 = pwd2; }
    public String getPwd3() { return pwd3; }
    public void setPwd3(String pwd3) { this.pwd3 = pwd3; }
}
