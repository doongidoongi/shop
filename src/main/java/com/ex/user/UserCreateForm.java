package com.ex.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserCreateForm {
	@Size(min=5, max=20)
	@NotEmpty(message = "아이디를 입력하세요.")
	private String username;
	
	
	@NotEmpty(message = "비밀번호를 입력하세요.")
	private String password1;
	
	
	@NotEmpty(message = "비밀번호 확인을 입력하세요.")
	private String password2;
	
	@Email
	@NotEmpty(message = "이메일을 입력하세요.")
	private String email;
}
