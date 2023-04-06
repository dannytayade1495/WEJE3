package com.jspiders.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repository;

}
