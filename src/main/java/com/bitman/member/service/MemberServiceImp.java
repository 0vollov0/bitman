package com.bitman.member.service;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitman.member.mapper.MemberMapper;

@Service
public class MemberServiceImp implements MemberService {
	@Autowired
	MemberMapper memberMapper;

	@Autowired
	MemberJson memberJson;

	@Override
	public JSONObject login(String mail, String password, HttpSession session) {
		return memberJson.loginResult(memberMapper.login(mail, password), session);
	}
}
