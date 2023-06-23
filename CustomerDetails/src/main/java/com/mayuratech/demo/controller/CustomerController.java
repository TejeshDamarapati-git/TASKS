package com.mayuratech.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mayuratech.demo.entity.Customer;
import com.mayuratech.demo.repository.CustomerRepository;
import com.mayuratech.demo.service.CustomerService;

@Controller
public class CustomerController {
	
	private CustomerService customerservice;
	@Autowired
	private CustomerRepository customerrepository;
	
	@Autowired
	public CustomerController(CustomerService customerservice) {
		this.customerservice = customerservice;
	}

	@RequestMapping("/")
	public String add() {
		return "addcustomer";
	}
	
	@RequestMapping("/add")
	public String getAllCustomers(@ModelAttribute("customer") Customer customer,Model model) {
		customerrepository.save(customer);
		List<Customer> allCustomers = customerservice.getAllCustomers();
		 model.addAttribute("customer", allCustomers);
		return "showcustomer";
	}
	
	@RequestMapping("/get")
	public String toGetCustomersById(Long id) {
		return "customerbyid";
	}
	
	@RequestMapping("/getbyid")
	public String getCustomersById(@RequestParam("id") Long id,Model model) {
		 Optional<Customer> byId = customerservice.getById(id);
		 Customer customer = byId.get();
		 model.addAttribute("customer", customer);
		 return "viewcustomer";
	}
	
	@RequestMapping("Delete")
	public String deleteCustomerById(Long id,Model model) {
		 customerservice.deleteById(id);
		 List<Customer> allCustomers = customerservice.getAllCustomers();
		 model.addAttribute("customer", allCustomers);
		return "showcustomer";
	}
	
	@RequestMapping("/Update")
	public String update(Long id,Model model) {
		Optional<Customer> byId = customerservice.getById(id);
		 Customer customer1 = byId.get();
		 model.addAttribute("customer", customer1);
		 return "updatecustomer";
	}
	@RequestMapping("/edit")
	public String updateByPhoneNum(@ModelAttribute("customer")Customer customer,Model model) {
		 Customer customer2 = new Customer();
		 customer2.setId(customer.getId());
		 customer2.setPhonenum(customer.getPhonenum());
		 customer2.setName(customer.getName());
		 customer2.setEmail(customer.getEmail());
		 customerservice.addCustomers(customer2);
		 List<Customer> allCustomers = customerservice.getAllCustomers();
		 model.addAttribute("customer", allCustomers);
		 return "showcustomer";
	}
}
