package com.api.o2suppliers.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.o2suppliers.model.DoctorModel;

public interface DoctorRepository extends CrudRepository<DoctorModel, Integer> {

	DoctorModel findByEmail(String email);
	List<DoctorModel> findAll();

}
