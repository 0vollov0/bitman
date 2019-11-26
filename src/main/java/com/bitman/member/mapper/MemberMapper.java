package com.bitman.member.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitman.member.dto.Member;

@Mapper
public interface MemberMapper {
	Member findAll();
	
	Member login(@Param(value = "mail") String mail,@Param(value = "password") String password);
}
