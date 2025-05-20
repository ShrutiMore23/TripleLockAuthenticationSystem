package com.example.authsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public boolean validateUser(String username, String email, String pwd1, String pwd2, String pwd3) {
    	
    	System.out.println("redirecring");
        return userRepository.findByUsernameAndEmailAndPwd1AndPwd2AndPwd3(username, email, pwd1, pwd2, pwd3).isPresent();
        
    }
    
    public String isUserPresent(String email) {
    	User user = userRepository.findByEmail(email);
    	if(user == null) {
    		return null;
    	}
    	return  user.getUsername();
    }
}
