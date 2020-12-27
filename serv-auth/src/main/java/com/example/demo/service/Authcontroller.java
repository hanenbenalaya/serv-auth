package com.example.demo.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.repos.AdminRespository;


@RestController
public class Authcontroller {
	
	
	@Autowired
	private AdminRespository adRepository;
	
	
	@PostMapping("/authAdm")
	public String getAdmId(@Valid @RequestBody Admin auth) {
	
		Admin ad = adRepository.findByemail(auth.getEmail()).orElse(null);
System.out.println("admin: "+ad);
if(ad!=null) {
if (ad.getPwd().equals(auth.getPwd())&&(ad.getRole().equals("admin"))){
		String id =String.valueOf(ad.getId());
		System.out.println("admin  id :"+id);
		return (id);
}
System.out.println("not authorized ! ");
return null;
}
System.out.println("not authorized ! ");
return null;

	}
	
}
