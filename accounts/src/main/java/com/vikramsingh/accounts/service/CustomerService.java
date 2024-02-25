package com.vikramsingh.accounts.service;

import com.vikramsingh.accounts.dto.Customer;
import com.vikramsingh.accounts.dto.CustomerDetails;

/**
 * @author Vikram Singh on 26-02-2024
 * @git <a href="https://github.com/VikramThory">...</a>
 */
public interface CustomerService {

    CustomerDetails getCustomerDetails(Customer customer);

}
