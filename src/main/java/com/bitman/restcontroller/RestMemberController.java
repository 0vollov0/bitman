package com.bitman.restcontroller;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitman.member.service.MemberServiceImp;

@RestController
@RequestMapping("/member")
public class RestMemberController {
	@Autowired
	MemberServiceImp memberService;
	
	
	
	@PostMapping("/login")
	public JSONObject login(String mail, String password,HttpSession session) {
		return memberService.login(mail, password, session);
	}
}
