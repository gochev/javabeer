package org.gochev.controller;

import java.util.Collections;

import javax.validation.Valid;

import org.gochev.model.Event;
import org.gochev.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventRepository eventRepository;

	@RequestMapping("/new")
	@PreAuthorize("hasAuthority(('ORGANIZER')")
	public String newEvent(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("event", new Event());
		redirectAttributes.addFlashAttribute("isNew", true);
		return "redirect:/home";
	}
	
	@RequestMapping("/edit/{eventId}")
	@PreAuthorize("hasAuthority(('ORGANIZER')")
	public String editEvent(@PathVariable("eventId") final Long id, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("event", eventRepository.findOne(id));
		return "redirect:/home";
	}
	
	@RequestMapping("/view/{eventId}")
	@PreAuthorize("hasAuthority(('ORGANIZER')")
	public String viewEvent(@PathVariable("eventId") final Long id, Model model) {
		Page<Event> page = new PageImpl<>(Collections.singletonList(eventRepository.findOne(id)));
		model.addAttribute("page", page);
		return "home";
	}
	
	@RequestMapping("/delete/{eventId}")
	@PreAuthorize("hasAuthority(('ORGANIZER')")
	public String deleteEvent(@PathVariable("eventId") final Long id, Model model) {
		eventRepository.delete(eventRepository.findOne(id));
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority(('ORGANIZER')")
	public String saveEvent(@Valid Event event, BindingResult eventBindingResult, RedirectAttributes redirectAttributes) {
		if(eventBindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.event", eventBindingResult);
			redirectAttributes.addFlashAttribute("isNew", (event.getId() == null ? true : false ));
			redirectAttributes.addFlashAttribute("event", event);
			return "redirect:/home";
		}
		eventRepository.save(event);
		return "redirect:/home";
	}

}