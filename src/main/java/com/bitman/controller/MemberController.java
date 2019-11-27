package com.bitman.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitman.member.dto.Member;
import com.bitman.member.mapper.MemberMapper;
import com.bitman.utils.EmailServiceImpl;
import com.bitman.utils.RandomString;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	JavaMailSender emailSender;
	
	@ModelAttribute("contextPath")
	public String getContextPath(HttpServletRequest request) {
		System.out.println(request.getContextPath());
		return request.getContextPath();
	}

	@RequestMapping("/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}

	@GetMapping(value="/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	@ResponseBody
	@PostMapping(
			value="/join", 
			produces="application/json; charset=utf-8")
	public Object join(Member member, String name, String mail, String password, int second_password, int keep_KRW) {
		JSONObject jsonData = new JSONObject();
		String returnData = "";
		/*
		 * 
		 * Create user taken wallet 
		 * 
		 * */
		String wallet_address = "LKSJDFLKJSLDKKFJSD";
		memberMapper.join(name, mail, password, second_password, wallet_address, keep_KRW);
		
		returnData = "index";
		jsonData.put("url", returnData);
		return jsonData;
	}
	
	@ResponseBody
	@PostMapping(
			value="/mailSend", 
			produces="application/json; charset=utf-8")
	public Object mailSend(String subject, String mail) {
		System.out.println("::: mail test ::: " + mail);
		JSONObject jsonData = new JSONObject();
		int mailCheck = memberMapper.mailCheck(mail);
		String random = RandomString.random(5);
		String returnData = "";
		/*
		if(mailCheck != 0) {
			System.out.println("�ߺ��� �̸���");
			returnData = "overlap";
			jsonData.put("check", returnData);
			return jsonData;
		}else {
			System.out.println("ȸ������ ���� �̸���");
			subject = "[BITMAN] ȸ������ ������ȣ";
			String text = "������ȣ :: " + random;
			EmailServiceImpl esi = new EmailServiceImpl();
			esi.setJavaMailSender(emailSender);
			esi.sendSimpleMessage(mail, subject, text);
			returnData = random;
			jsonData.put("check", returnData);
			System.out.println("::: mail test success :::");
		}
		*/
		System.out.println("ȸ������ ���� �̸���");
		subject = "[BITMAN] ȸ������ ������ȣ";
		String text = "������ȣ :: " + random;
		EmailServiceImpl esi = new EmailServiceImpl();
		esi.setJavaMailSender(emailSender);
		esi.sendSimpleMessage(mail, subject, text);
		returnData = random;
		jsonData.put("check", returnData);
		System.out.println("::: mail test success :::");
		
		return jsonData;
	}
}
