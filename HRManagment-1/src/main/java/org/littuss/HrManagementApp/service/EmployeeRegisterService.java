package org.littuss.HrManagementApp.service;

import org.littuss.HrManagementApp.model.EmployeeRegisterEntity;
import org.littuss.HrManagementApp.repository.EmployeeRegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRegisterService{
	
	 @Autowired
	    private EmployeeRegisterRepo empRepo;
	 
	 public EmployeeRegisterEntity findByEmail(String email) {
	        return empRepo.findByEmail(email);
	    }

	 //registration 
	 public EmployeeRegisterEntity save(EmployeeRegisterEntity empres) {
	        return empRepo.save(empres);
	    }

	 //for login request
	 public EmployeeRegisterEntity findByEmailAndPassword(String email, String password) {
		 System.out.println("login request");
	        return empRepo.findByEmailAndPassword(email, password);
	    }
}
