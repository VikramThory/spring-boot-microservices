package com.vikramsingh.accounts.service.impl;

import com.vikramsingh.accounts.dto.Customer;
import com.vikramsingh.accounts.dto.CustomerDetails;
import com.vikramsingh.accounts.repository.AccountsRepository;
import com.vikramsingh.accounts.service.CustomerService;
import com.vikramsingh.accounts.service.client.CardsFeignClient;
import com.vikramsingh.accounts.service.client.LoansFeignClient;
import org.springframework.stereotype.Service;

/**
 * @author Vikram Singh on 26-02-2024
 * @git <a href="https://github.com/VikramThory">...</a>
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final AccountsRepository accountsRepository;
    private final CardsFeignClient cardsFeignClient;
    private final LoansFeignClient loansFeignClient;

    public CustomerServiceImpl(AccountsRepository accountsRepository, CardsFeignClient cardsFeignClient, LoansFeignClient loansFeignClient) {
        this.accountsRepository = accountsRepository;
        this.cardsFeignClient = cardsFeignClient;
        this.loansFeignClient = loansFeignClient;
    }

    @Override
    public CustomerDetails getCustomerDetails(String correlationId, Customer customer) {
        var accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        var loans = loansFeignClient.getLoansDetails(correlationId, customer);
        var cards = cardsFeignClient.getCardDetails(correlationId, customer);
        var customerDetails = new CustomerDetails();
        customerDetails.setAccounts(accounts);
        if (cards != null)
            customerDetails.setCards(cards);
        if (loans != null)
            customerDetails.setLoans(loans);
        return customerDetails;
    }
}
