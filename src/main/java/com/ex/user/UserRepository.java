package com.ex.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<ShopUser, Long>{
	Optional<ShopUser> findByUsername(String username);
	Optional<ShopUser> findByEmail(String email);
	// Optional<ShopUser> findByGrade(Grade grade);
}
