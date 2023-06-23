package com.mayuratech.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayuratech.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
