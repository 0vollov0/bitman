package com.bitman.member.dto;

import java.util.Date;

public class Member {
	private int id;
	private String name;
	private String mail;
	private String password;
	private String second_password;
	private String wallet_address;
	private Date join_date;
	private int keep_KRW;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecond_password() {
		return second_password;
	}

	public void setSecond_password(String second_password) {
		this.second_password = second_password;
	}

	public String getWallet_address() {
		return wallet_address;
	}

	public void setWallet_address(String wallet_address) {
		this.wallet_address = wallet_address;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public int getKeep_KRW() {
		return keep_KRW;
	}

	public void setKeep_KRW(int keep_KRW) {
		this.keep_KRW = keep_KRW;
	}

}
