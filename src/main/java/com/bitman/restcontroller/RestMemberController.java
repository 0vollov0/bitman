package com.bitman.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitman.member.dto.Member;
import com.bitman.member.mapper.MemberMapper;

@RestController
@RequestMapping("/member")
public class RestMemberController {
	@Autowired
	MemberMapper memberMapper;
	
	@GetMapping("/findAll")
	public int findAll(Model model) {
		Member member = memberMapper.findAll();
		return member.getId();
	}
}
