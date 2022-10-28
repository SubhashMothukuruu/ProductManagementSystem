package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Users;
import com.example.demo.Service.UserService;

import SecurityService.SecurityService;
import Validation.Validations;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@Autowired
	SecurityService securityService;
	
	
	@Autowired
	private Validations userValidator;
	
	
	 @GetMapping("/registration")
	    public String registration(Model model) {
	        model.addAttribute("userForm", new Users());

	        return "registration";
	    }

	    @PostMapping("/registration")
	    public String registration(@ModelAttribute("userForm") Users userForm, BindingResult bindingResult) {
	        userValidator.validate(userForm, bindingResult);

	        if (bindingResult.hasErrors()) {
	            return "registration";
	        }

	        userService.save(userForm);

	        securityService.autoLogin(userForm.getUsername(), userForm.getPassword());

	        return "redirect:/home";
	    }

	    @GetMapping("/login")
	    public String login(Model model, String error, String logout) {
	        if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");

	        return "login";
	    }
	
	
}
