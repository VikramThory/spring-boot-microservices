package com.vikramsingh.accounts.controller;

import com.vikramsingh.accounts.dto.CustomerDetails;
import com.vikramsingh.accounts.model.Accounts;
import com.vikramsingh.accounts.model.Customer;
import com.vikramsingh.accounts.repository.AccountsRepository;
import com.vikramsingh.accounts.service.CustomerService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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

	@Retry(name = "getBuildInfo", fallbackMethod = "getBuildInfoFallback")
	@GetMapping("/build-info")
	public ResponseEntity<String> getBuildInfo() {
		return ResponseEntity.status(HttpStatus.OK).body("0.0.1");
	}

//	Creating a fallback method for retry this method should accept the same no. of arguments and Throwable interface
	public ResponseEntity<String> getBuildInfoFallback(Throwable throwable) {
		return ResponseEntity.status(HttpStatus.OK).body("0");
	}

	@RateLimiter(name = "getJavaVersion", fallbackMethod = "getJavaVersionFallback")
	@GetMapping("/java-version")
	public ResponseEntity<String> getJavaVersion() {
		return ResponseEntity.status(HttpStatus.OK).body("21");
	}

	public ResponseEntity<String> getJavaVersionFallback(Throwable throwable) {
		return ResponseEntity.status(HttpStatus.OK).body("11");
	}

	@GetMapping("/customer-details")
	public ResponseEntity<CustomerDetails> getCustomerDetails(@RequestHeader("vikramthory-correlation-id") String correlationId, @RequestParam int customerId) {
		var customer = new com.vikramsingh.accounts.dto.Customer();
		customer.setCustomerId(customerId);
		logger.debug("VikramThory-correlation-id found: {}", correlationId);
        return ResponseEntity.ok(customerService.getCustomerDetails(correlationId, customer));
	}

}
