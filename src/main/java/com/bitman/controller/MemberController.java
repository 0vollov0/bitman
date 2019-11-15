package com.bitman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}

	@RequestMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}
}
