package com.mujae.member.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;



@Alias("mdto")
public class MemberDTO {
	private int user_code;
	private String id;
	private String pwd;
	private String name;
	private String email;

	public MemberDTO() {
	}

	public MemberDTO(String id, String pwd, String name, String email, int user_code) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.user_code = user_code;


	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUser_code() {
		return user_code;
	}

	public void setUser_code(int user_code) {
		this.user_code = user_code;
	}

	@Override
	public String toString() {
		return "MemberDTO{" +
				"id='" + id + '\'' +
				", pwd='" + pwd + '\'' +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", user_code='" + user_code + '\'' +
				'}';
	}
}
