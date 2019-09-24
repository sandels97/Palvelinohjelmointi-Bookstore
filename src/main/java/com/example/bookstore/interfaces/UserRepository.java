package com.example.bookstore.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.example.bookstore.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
