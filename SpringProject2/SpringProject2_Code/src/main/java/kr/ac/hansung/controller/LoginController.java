package kr.ac.hansung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String showLogin( @RequestParam(value="error", required=false) String error, 
							@RequestParam(value="logout", required=false) String logout,
							Model model ) {
		
		if(error != null) { // /login?error
			model.addAttribute("errorMsg", "Invalid username and password");
		}
		
		if(logout != null) { // /login?error
			model.addAttribute("logoutMsg", "You've been logged out successfully");
		}
		
		return "login";
	}
}
