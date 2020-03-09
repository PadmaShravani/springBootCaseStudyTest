package com.perscholas.PRGS;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
	@Autowired
	private UsersService service;
	
	private String loggedInUser = null;
	
	@RequestMapping("/prgs")
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
		public String saveUser(@ModelAttribute("users") ModelUsers users) {
		service.save(users);
	
		return "login";
	}

//	public String validateUserNameInfo(Model model1, @Valid ModelUsers users1, BindingResult bindingResult) {
//	    if (bindingResult.hasErrors()) {
//	    	
//	        return "home";
//	    }
//	    model1.addAttribute("user", users1.getUserName());
//	    service.save(users1);
//	    return "login";
//	    }

	
	@RequestMapping("/existing_user")
	public String userLogin(Model model) {		
		ModelUsers users = new ModelUsers();
		model.addAttribute("users", users);		
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String validateLoginInfo(@ModelAttribute ModelUsers user, Model model) {
		System.out.println("Entered :"+user.getEmail());
		System.out.println("Entered :"+user.getPassword());
		ModelUsers exist_user;
		try {
			exist_user = service.findByEmail(user.getEmail());
			System.out.println("From DB :"+exist_user.getEmail());
			System.out.println("From DB :"+exist_user.getPassword());
			if(!exist_user.getPassword().equalsIgnoreCase(user.getPassword())) {
				System.out.println("Not a valid password. Please click forgot password");			
				return "login";
			}else
			{
				//loggedInUser = user.getEmail();
				loggedInUser = exist_user.getFirstName()+" "+exist_user.getLastName();
				model.addAttribute("msg", "Logged in as "+loggedInUser);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not a valid email. Please register using sign up");	
		}				
        return "userViewPage";
    }
	
//	@ModelAttribute
//	public void addAttributes(Model model) {
//	    model.addAttribute("msg", "Logged in as");
//	}
	
//	@RequestMapping("/userViewPage")
//	public String userViewPage(Model model) {
//		return "";
//	}
	

	
//	@RequestMapping("/edit/{id}")
//	public ModelAndView showEditUserForm(@PathVariable(name="id") int id) {
//		
//		ModelAndView mav = new ModelAndView("edit_users");
//		ModelUsers users = service.get(id);
//		mav.addObject("users", users);
//		
//		return mav;
//	}
//	
//	@RequestMapping("/delete/{id}")
//	public String deleteUser(@PathVariable(name="id") int id) {
//		
//		
//		service.delete(id);
//		return "redirect:/";
//	}
	
}


