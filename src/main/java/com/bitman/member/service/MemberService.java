package com.bitman.member.service;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.bitman.member.dto.Member;

public interface MemberService {
	public JSONObject login(String mail,String password,HttpSession session);
}
