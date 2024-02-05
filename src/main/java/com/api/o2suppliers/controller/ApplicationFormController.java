package com.api.o2suppliers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.o2suppliers.model.ApplicationForm;
import com.api.o2suppliers.service.ApplicationFormService;

@RestController
@RequestMapping("/api/application")
public class ApplicationFormController {
	@Autowired
	ApplicationFormService formService;

	@GetMapping("/getAll")
	@CrossOrigin
	public List<ApplicationForm> getAll() {
		return formService.getAll();
	}

	@PostMapping("/applyForm")
	@CrossOrigin
	public void applyForm(@RequestBody ApplicationForm form) {

		formService.applyForm(form);
	}

	@GetMapping("/myapplications/{email}")
	@CrossOrigin
	public List<ApplicationForm> getMyApplications(@PathVariable("email") String email) {

		return formService.getApplicationWithUserId(email);
	}

	@PutMapping("/cancel")
	@CrossOrigin
	public void cancelForm(@RequestBody ApplicationForm form) {
		formService.updateForm(form);
	}
	@PutMapping("/revoke")
	@CrossOrigin
	public void revokeForm(@RequestBody ApplicationForm form) {
		formService.updateForm(form);
	}

	@GetMapping("/waitingwith/doctor")
	@CrossOrigin
	public List<ApplicationForm> getApplicationWaitingWithDoctor() {

		System.out.println(formService.getApplicationWaitingWithDoctor());
		return formService.getApplicationWaitingWithDoctor();

	}

	@PutMapping("/approve")
	@CrossOrigin
	public List<ApplicationForm> approveRequesst(@RequestBody ApplicationForm form) {

		formService.approveRequest(form);
		return formService.getApplicationWaitingWithDoctor();
	}

	@GetMapping("/waitingwith/supplier")
	@CrossOrigin
	public List<ApplicationForm> getApplicationWaitingWithSupplier() {
		return formService.getApplicationWaitingWithSupplier();
	}

	@PutMapping("/approve/delivery")
	@CrossOrigin
	public List<ApplicationForm> approveDelivery(@RequestBody ApplicationForm form) {
		formService.approveDelivery(form);
		return formService.getApplicationWaitingWithSupplier();
	}

}
