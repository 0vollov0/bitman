package com.bitman.member.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitman.member.dto.Member;

@Mapper
public interface MemberMapper {
	Member findAll();
	
	Member login(@Param(value = "mail") String mail,@Param(value = "password") String password);
	
	Integer mailCheck(@Param(value="mail") String mail);
	
	void join(@Param(value="name") String name, @Param(value="mail") String mail,
			@Param(value="password") String password, @Param(value="second_password") int second_password, 
			@Param(value="wallet_address") String wallet_address, @Param(value="keep_KRW") int keep_KRW);
}
