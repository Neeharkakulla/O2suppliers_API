package com.api.o2suppliers.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.o2suppliers.model.UserDetails;

public interface UserRepository extends CrudRepository<UserDetails, Integer>{

	UserDetails findByEmail(String email);
	
	UserDetails findById(int id);
	
	List<UserDetails> findAll();
}
