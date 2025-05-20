package com.example.authsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsernameAndEmailAndPwd1AndPwd2AndPwd3(String username, String email, String pwd1, String pwd2, String pwd3);

	User findByEmail(String email);

}
