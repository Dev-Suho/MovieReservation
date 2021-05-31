package com.java.dto;

import java.sql.Timestamp;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String tel;
	private String addr;
	private String birth;
	private String gender;
	private Timestamp createDate;
	
	public Member() {}

	public Member(String id, String pwd, String name, String tel, String addr,
			String birth, String gender, Timestamp creteDate) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.birth = birth;
		this.gender = gender;
		this.createDate = creteDate;
	}
	
	public Member(String id) {
		this.id = id;
	}
	
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
