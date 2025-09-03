package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Contact;
import com.example.demo.repository.contactRepository;



@Controller
public class Homecontroller {

	  @Autowired
	    private contactRepository ContactRepository;
	
	  @GetMapping("/")
	    public String home(Model model) {
	        model.addAttribute("name", "H. Synul Sohail");
	        model.addAttribute("role", "Full-Stack Java Developer");
	        model.addAttribute("location", "Chennai, Tamil Nadu, India");
	        model.addAttribute("email", "synulsuhail@gmail.com");
	        model.addAttribute("phone", "+91 9629918733");
	        model.addAttribute("linkedin", "https://linkedin.com/in/YOUR-LINK");

	        return "home";
	    }
	  
//	  @GetMapping("/index")
//		  public String homes(Model model) {
//		  return "index";
//			  }
	
	

	  @PostMapping("/contact")
	  public String handleContactForm(Contact contact, Model model) {
		  ContactRepository.save(contact);
	      model.addAttribute("successMessage", "Thank you for contacting us!");
	      return "home";  // or redirect:/home
	  }

	

}