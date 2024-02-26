package com.vikramsingh.accounts.controller;

import com.vikramsingh.accounts.dto.CustomerDetails;
import com.vikramsingh.accounts.model.Accounts;
import com.vikramsingh.accounts.model.Customer;
import com.vikramsingh.accounts.repository.AccountsRepository;
import com.vikramsingh.accounts.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountsController {

	private static final Logger logger = LoggerFactory.getLogger(AccountsController.class);

	private final AccountsRepository accountsRepository;

	private final CustomerService customerService;

    public AccountsController(AccountsRepository accountsRepository, CustomerService customerService) {
        this.accountsRepository = accountsRepository;
        this.customerService = customerService;
    }

    @PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {

		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		if (accounts != null) {
			return accounts;
		} else {
			return null;
		}

	}

	@GetMapping("/customer-details")
	public ResponseEntity<CustomerDetails> getCustomerDetails(@RequestHeader("vikramthory-correlation-id") String correlationId, @RequestParam int customerId) {
		var customer = new com.vikramsingh.accounts.dto.Customer();
		customer.setCustomerId(customerId);
		logger.debug("VikramThory-correlation-id found: {}", correlationId);
        return ResponseEntity.ok(customerService.getCustomerDetails(correlationId, customer));
	}

}
