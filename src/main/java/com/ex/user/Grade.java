package com.ex.user;

import lombok.Getter;

@Getter
public enum Grade {
	ADMIN("ROLE_ADMIN"), SELLER("ROLE_USER"), USER("ROLE_USER"), DELUSER("ROLE_DELUSER");

	private String value;

	Grade(String value) {
		this.value = value;
	}
}
