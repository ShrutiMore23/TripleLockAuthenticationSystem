package com.example.authsystem;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class ForgotPasswordController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/forgotPassword")
    public String showForgotPasswordForm() {
        return "forgotPassword";
    }

    @PostMapping("/forgotPassword")
    public String processForgotPassword(@RequestParam String email, Model model) {
        User user = userRepo.findByEmail(email);
        
        if (user != null) {
            // For simplicity, redirect to reset page with email as a query parameter
            return "redirect:/resetPassword?email=" + email;
        } else {
            model.addAttribute("error", "User not found");
            return "forgotPassword";
        }
    }
    
    
    
    @GetMapping("/resetPassword")
    public String showResetForm(@RequestParam String email, Model model) {
        model.addAttribute("email", email);
        return "resetPassword";
    }

    @PostMapping("/resetPassword")
    public String processReset(
            
            @RequestParam String email,
            @RequestParam String pwd1,
            @RequestParam String pwd2,
            @RequestParam String pwd3,
            Model model) {

        User user = userRepo.findByEmail(email);
        
        if (user != null) {
            user.setPwd1(pwd1); // hash it if you store passwords securely
            user.setPwd2(pwd2);
            user.setPwd3(pwd3);
            
            userRepo.save(user);
            
            model.addAttribute("message", "Password reset successful! Please login.");
            return "redirect:/login";

            
        } else {
            model.addAttribute("error", "User not found");
            return "forgotPassword";
        }
    }

    
    
}

