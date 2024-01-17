package org.littuss.HrManagementApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EmployeeRegisterDetails")
public class EmployeeRegisterEntity {

	//fields for Front End
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	private String password;
	
	//noArgConstructor
	public EmployeeRegisterEntity() {	}

	//AllAgsConstructor Except id
	public EmployeeRegisterEntity( String firstname, String lastname, String email, String mobile,
			String password) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public String getPassword() {
		return password;
	}

	//setters
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//to string
	@Override
	public String toString() {
		return "EmployeeRegisterEntity [id=" + id + ", fullname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", mobile=" + mobile + ", password=" + password + "]";
	}
	
}
