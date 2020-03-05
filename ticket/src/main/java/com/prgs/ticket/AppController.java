package com.prgs.ticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
	private TicketRepository repo;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<ModelTicketDetails> listTickets=repo.findAll();
		System.out.println(listTickets.size()+"  size");
		model.addAttribute("listTicket", listTickets);
		return "ticket";
	}
	@RequestMapping("/new")
	public String showNewTicketForm(Model model) {
		ModelTicketDetails ticket = new ModelTicketDetails();
		model.addAttribute("ticket", ticket);

 		return "ticket";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveTicket(@ModelAttribute("ticket") ModelTicketDetails ticket) {
	repo.save(ticket);	
		
		return "redirect:/";
		
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditTicketForm(@PathVariable(name="id") int id) {
		
		ModelAndView mav = new ModelAndView("edit_ticket");
		ModelTicketDetails ticket = repo.findById(id).get();
		mav.addObject("ticket", ticket);
		
		return mav;
	}
	
		
	}
