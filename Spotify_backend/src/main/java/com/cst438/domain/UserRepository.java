package com.cst438.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserProfile, Integer> {
	UserProfile findByUsername(String username);
}
