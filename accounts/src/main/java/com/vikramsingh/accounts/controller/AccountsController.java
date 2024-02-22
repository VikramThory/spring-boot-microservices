package com.vikramsingh.accounts.controller;

import com.vikramsingh.accounts.model.Accounts;
import com.vikramsingh.accounts.model.Customer;
import com.vikramsingh.accounts.repository.AccountsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

	private final AccountsRepository accountsRepository;

    public AccountsController(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
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

}
