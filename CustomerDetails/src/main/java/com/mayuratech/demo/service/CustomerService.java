package com.mayuratech.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayuratech.demo.entity.Customer;
import com.mayuratech.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private CustomerRepository customerrepository;

	@Autowired
	public CustomerService(CustomerRepository customerrepository) {
		this.customerrepository = customerrepository;
	}
	
	public List<Customer> getAllCustomers(){
		return customerrepository.findAll();
	}
	public Optional<Customer> getById(Long id){
		return customerrepository.findById(id);
	}
	
	public Customer addCustomers(Customer customer){
		return customerrepository.save(customer);
	}
	
	public void deleteById(Long id) {
		customerrepository.deleteById(id);
	}
	
	public Customer updateCustomerMobileNum(Long id,Long newphonenum) {
		 Optional<Customer> optionalCustomer = customerrepository.findById(id);
	        if (optionalCustomer.isPresent()) {
	            Customer customer = optionalCustomer.get();
	            customer.setPhonenum(newphonenum);
	            return customerrepository.save(customer);
	        }
	        return null;
	    }
}
