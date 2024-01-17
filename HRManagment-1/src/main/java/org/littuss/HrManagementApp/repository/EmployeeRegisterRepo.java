package org.littuss.HrManagementApp.repository;

import org.littuss.HrManagementApp.model.EmployeeRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRegisterRepo extends JpaRepository<EmployeeRegisterEntity, Long>{
     
	EmployeeRegisterEntity findByEmail(String email);
	
	 EmployeeRegisterEntity findByEmailAndPassword(String email, String password);
}
