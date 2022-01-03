package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Phone;
import com.example.demo.repository.PhoneRepository;

@Service
public class PhoneService {
	@Autowired
	private PhoneRepository repository;
	
	
	
	public List<Phone> getPhoneNumbers(){
		return repository.findAll();
	}
	public Optional<Phone> getPhoneNumber(int p){
		return repository.findById(p);
	}
	
	
	
	
	public Phone savePhoneNumber(Phone p) {
		return repository.save(p);
	}
	
	
	
	public String deletePhoneNumber(int p) {
		repository.deleteById(p);
		return "Deleted Successfully";
	}
	public String deleteAllPhoneNumbers() {
		repository.deleteAll();
		return "Deleted Successfully";
	}
	
	
	
	public Phone updatePhoneNumber(Phone p) {
		Phone existing = repository.findById(p.getPhoneId()).orElse(null);
		existing.setPhoneNum(p.getPhoneNum());
		existing.setAddress(p.getAddress());
		existing.setName(p.getName());
		return repository.save(existing);
	}
}
