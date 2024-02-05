package com.api.o2suppliers.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.api.o2suppliers.model.ImageModel;

public interface ImageRepository extends CrudRepository<ImageModel, Long> {
	Optional<ImageModel> findByName(String name);
}