package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Phone;
import com.example.demo.service.PhoneService;

@RestController
@RequestMapping("/api")
public class PhoneController {
	@Autowired
	private PhoneService service;
	
	@GetMapping(path="/getPhoneNumbers")
	public List<Phone> getPhoneNumbers(){
		return service.getPhoneNumbers();
	}
	@GetMapping(path="/getPhoneNumber/{phoneId}")
	public Optional<Phone> getPhoneNumber(@PathVariable("phoneId") int p){
		return service.getPhoneNumber(p);
	}
	
	
	@PostMapping(path="/addPhoneNumber")
	public Phone savePhoneNumber(@RequestBody Phone p) {
		return service.savePhoneNumber(p);
	}
	
	
	@DeleteMapping(path="/deletePhoneNumber/{phoneId}")
	public String deletePhoneNumber(@PathVariable("phoneId") int p) {
		return service.deletePhoneNumber(p);
	}
	@DeleteMapping(path="/deleteAllPhoneNumbers")
	public String deleteAllPhoneNumbers() {
		return service.deleteAllPhoneNumbers();
	}
	
	
	@PutMapping(path="/updatePhoneNumber")
	public Phone updatePhoneNumber(@RequestBody Phone p) {
		return service.updatePhoneNumber(p);
	}
}
