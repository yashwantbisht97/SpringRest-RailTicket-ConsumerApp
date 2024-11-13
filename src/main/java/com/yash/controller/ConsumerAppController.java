package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yash.binding.Ticket;
import com.yash.service.ConsumerAppService;



@Controller
public class ConsumerAppController {
	@Autowired
	private ConsumerAppService service;
	@GetMapping("/")
	public String index(Model model) {
		List<Ticket> allTickets=service.getAllTickets();
		model.addAttribute("tickets",allTickets);
		return "index";
	}
	
	

}
