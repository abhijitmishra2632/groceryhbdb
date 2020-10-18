package com.cosmos.contactnumbers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v2")
public class UserUIController {
	@GetMapping(value = "/")
	public String helloWorld() {
		System.out.println("Hello");
		return "index";
	}

}
