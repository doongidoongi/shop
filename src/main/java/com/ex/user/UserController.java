package com.ex.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")

public class UserController {
	private final UserService userService;

	@GetMapping("/signup")
	public String singup(UserCreateForm userCreateForm) {
		return "sign_form";
	}

	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "sign_form";
		}
		if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordInCorrect", "비밀번호와 비밀번호 확인 불일치.");
			return "sign_form";
		}
		try {
			this.userService.create(userCreateForm.getUsername(), userCreateForm.getPassword1(),
					userCreateForm.getEmail(), Grade.USER);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.rejectValue("signupFailed", "사용할수 없는 아이디 입니다.");
			return "sign_form";
		} catch (Exception e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", e.getMessage());
		}

		return "redirect:/user/main";
	}

	@GetMapping("/login")
	public String login() {
		return "login_form";
	}
	@GetMapping("/main")
	public String main() {
		return "shop_main";
	}
}
