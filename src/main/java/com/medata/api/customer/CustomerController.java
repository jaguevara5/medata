package com.medata.api.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customers")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService _customerService) {
		customerService = _customerService;
	}

	@GetMapping("")
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Optional<Customer> customer = customerService.findById(customerId);
		if (!customer.isPresent()) {
			throw new RuntimeException("Customer with id " + customerId + " not found!");
		}
		return customer.get();
	}

	@PostMapping("")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
		return customer;
	}

	@PutMapping("")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
		return customer;
	}

	@DeleteMapping("/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Optional<Customer> customer = customerService.findById(customerId);
		if (!customer.isPresent()) {
			throw new RuntimeException("Customer with id " + customerId + " not found!");
		}
		customerService.deleteById(customerId);
		return "Customer with id " + customerId + " was removed successfully";
	}
}
