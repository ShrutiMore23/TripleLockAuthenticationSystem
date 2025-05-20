package com.example.authsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

//    private final UserRepository userRepository;

    @Autowired
    private UserService userService;

//    AuthController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @GetMapping("/")
    public String welcomePage() {
        return "welcome";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser( User user, Model model) {
    	
    	String email = user.getEmail();
    	System.out.println(userService.isUserPresent(email));
    	
    	if(userService.isUserPresent(email) != null  ) {
    		 model.addAttribute("message", "This user already exists.  ");
    		 
    	} else {
    		model.addAttribute("message", "Succesfully Registered!! Now Go for Login" );
    		userService.saveUser(user);
    	}
        return "register";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
    						@RequestParam String email,
    						@RequestParam String pwd1,
                            @RequestParam String pwd2,
                            @RequestParam String pwd3,
                            Model model) {
        if (userService.validateUser(username, email, pwd1, pwd2, pwd3)) {
        	System.out.println(username+" found");
            return "home";
        } else {
            model.addAttribute("error", "Invalid credentials");
            System.out.println(username + " not found");
            return "login";
        }
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
    
    
   
}
