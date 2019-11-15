package com.bitman.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bitman.member.dto.Member;

@Mapper
public interface MemberMapper {
	Member findAll();
}
