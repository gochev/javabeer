package org.gochev.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value = { "/", "/login" })
	public String greeting(Model model, Pageable pageable) {
		model.addAttribute("page", null);
		return "login";
	}
}
