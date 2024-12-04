package com.ex.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ex.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	
	public ShopUser create(String username, String password, String email, Grade grade) {
		ShopUser user=new ShopUser();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setGrade(Grade.USER);
		return this.userRepository.save(user);
	}
	public ShopUser getUser(String username) {
		Optional<ShopUser> shopUser=this.userRepository.findByUsername(username);
		if(shopUser.isPresent()) {
			return shopUser.get();
		}else {
			throw new DataNotFoundException("");
		}
	}
}
