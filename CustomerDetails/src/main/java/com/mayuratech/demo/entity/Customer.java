package com.mayuratech.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TableCustomerDetails")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;
	
	 @Column(name = "name")
	private String name;
	 
	 @Column(name = "email")
	private String email;
	 
	 @Column(name = "phonenum")
	private Long phonenum;
	
	 public Customer(Long id, String name, String email, Long phonenum) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.phonenum = phonenum;
		}
	 public Customer() {
			super();
		}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(Long newphonenum) {
		this.phonenum = newphonenum;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phonenum=" + phonenum + "]";
	}
	
	

}
