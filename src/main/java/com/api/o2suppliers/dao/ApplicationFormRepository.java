package com.api.o2suppliers.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.o2suppliers.model.ApplicationForm;

public interface ApplicationFormRepository extends CrudRepository<ApplicationForm, Integer> {

	ArrayList<ApplicationForm> findByApplicantMail(String applicantMail);

	List<ApplicationForm> findByWaitingWith(String waitingWith);
	
	List<ApplicationForm> findAll();

}
