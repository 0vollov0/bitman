package com.bitman.member.service;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import com.bitman.member.dto.Member;

@Repository
public class MemberJson {
	public JSONObject loginResult(Member member,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		if (member == null) {
			jsonObject.put("result", 0);
		}else {
			jsonObject.put("result", 1);
			session.setAttribute("id", member.getId());
			session.setMaxInactiveInterval(3600);
		}
		return jsonObject;
	}
}
