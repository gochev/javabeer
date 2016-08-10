package org.gochev.controller;

import org.gochev.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired
	private EventRepository eventRepository;

	@RequestMapping(value = { "/", "/home" })
	public String greeting(Model model, Pageable pageable) {
		model.addAttribute("page", eventRepository.findByOrderByStartTimeDesc(pageable));
		return "home";
	}

}