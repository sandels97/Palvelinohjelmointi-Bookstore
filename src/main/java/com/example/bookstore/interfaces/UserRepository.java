package com.example.bookstore.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String name);
}
