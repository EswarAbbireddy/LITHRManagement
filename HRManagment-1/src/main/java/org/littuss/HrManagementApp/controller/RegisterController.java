package org.littuss.HrManagementApp.controller;

import org.littuss.HrManagementApp.LoginVariables.LoginRequest;
import org.littuss.HrManagementApp.model.EmployeeRegisterEntity;
import org.littuss.HrManagementApp.service.EmployeeRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users") //main
@CrossOrigin("*")
public class RegisterController {

	 @Autowired
	 private EmployeeRegisterService empRegSer;
	 
	 //register
	 @GetMapping("/register/{email}")
	 public EmployeeRegisterEntity getUserByEmail(@PathVariable String email) {
	        return empRegSer.findByEmail(email);
	    }
	 
		/*
		 * // @PostMapping("/register") // public EmployeeRegisterEntity
		 * createUser(@RequestBody EmployeeRegisterEntity EmpregEnt) { // String email =
		 * EmpregEnt.getEmail(); // EmployeeRegisterEntity user =
		 * empRegSer.findByEmail(email); // if (user == null) { // return
		 * empRegSer.save(EmpregEnt); // } // else // { // return null; // } // }
		 */ 
	 @PostMapping("/register")
	 public ResponseEntity<String> createUser(@RequestBody EmployeeRegisterEntity empRegEnt) {
	     String email = empRegEnt.getEmail();
	     EmployeeRegisterEntity existingUser = empRegSer.findByEmail(email);

	     if (existingUser == null) {
	         // Email is not taken, so save the user
	        //ex: EmployeeRegisterEntity savedUser = empRegSer.save(empRegEnt);
	    	 empRegSer.save(empRegEnt);
	         return ResponseEntity.ok("User registered successfully");
	     } else {
	         // Email is already taken, return a response indicating that
	         return ResponseEntity.badRequest().body("Email address already taken");
	     }
	 }
	 //login
	 @PostMapping("/login")
	    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
	        String email = loginRequest.getEmail();
	        String password = loginRequest.getPassword();

	        // Perform login validation
	        EmployeeRegisterEntity user = empRegSer.findByEmailAndPassword(email, password);

	        if (user != null && password.equals(user.getPassword())) {
	            // Successful login
	            return ResponseEntity.ok("Login successful");
	        } else {
	            // Failed login
	             return ResponseEntity.badRequest().body("Login failed");
	        }
	    }
}
