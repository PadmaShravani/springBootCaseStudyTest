package com.perscholas.prgs.Registration;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
	private UsersService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<ModelUsers> listUsers = service.listAll();
		model.addAttribute("listUsers", listUsers);
		return "home";
	}
	@RequestMapping("/new_user")
	public String showNewUserForm(Model model) {
		
		ModelUsers users = new ModelUsers();
		model.addAttribute("users", users);
		
		return "signUp";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)

	public String validateUserNameInfo(Model model1, @Valid ModelUsers users1, BindingResult bindingResult) {
	    if (bindingResult.hasErrors()) {
	    	
	        return "home";
	    }
	    model1.addAttribute("user", users1.getUserName());
	    service.save(users1);
	    return "login";
	    }
//	public String saveUser(@ModelAttribute("users") ModelUsers users) {
//		service.save(users);
//	
//		return "redirect:/";
//	}
	
	@RequestMapping("/login")
	public String validateLoginInfo(Model model, @Valid ModelUsers users, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        model.addAttribute("user", users.getUserName());
        return "home";
    }
	
		
	
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditUserForm(@PathVariable(name="id") int id) {
		
		ModelAndView mav = new ModelAndView("edit_users");
		ModelUsers users = service.get(id);
		mav.addObject("users", users);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name="id") int id) {
		
		
		service.delete(id);
		return "redirect:/";
	}
	
}


