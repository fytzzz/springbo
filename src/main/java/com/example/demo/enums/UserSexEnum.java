package com.example.demo.enums;
public enum UserSexEnum {
	MAN("0"), WOMAN("1");

	private String sex;

	public String getSex() {
		return sex;
	}

	UserSexEnum(String sex) {
		this.sex = sex;
	}
}
