package com.mayuratech.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayuratech.demo.entity.BankCustomer;

public interface BankRepository extends JpaRepository<BankCustomer, Integer>{

	
}
