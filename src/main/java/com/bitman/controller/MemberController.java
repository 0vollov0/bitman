package com.bitman.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	@ModelAttribute("contextPath")
	public String getContextPath(HttpServletRequest request) {
		System.out.println(request.getContextPath());
		return request.getContextPath();
	}

	@RequestMapping("/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}

	@RequestMapping("/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
}
