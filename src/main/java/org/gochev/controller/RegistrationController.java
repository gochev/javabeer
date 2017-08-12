package org.gochev.controller;

import org.gochev.model.User;
import org.gochev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = { "/", "/registration" })
	public String registration(Model model, Pageable pageable) {
		model.addAttribute("page", null);
		return "registration";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String createNewUser(@RequestParam String username, @RequestParam String password,
			@RequestParam String confirmPassword, @RequestParam String email, @RequestParam String firstname,
			@RequestParam String lastname) {

		User n = new User();
		n.setUsername(username);
		n.setPassword(password);
		n.setEmail(email);
		n.setFirstName(firstname);
		n.setLastName(lastname);
		n.setStatus("Pending");

		userRepository.save(n);
		//return "redirect:/home";
		return "";
	}
}
