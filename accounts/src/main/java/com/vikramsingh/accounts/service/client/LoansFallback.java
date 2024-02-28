package com.vikramsingh.accounts.service.client;

import com.vikramsingh.accounts.dto.Customer;
import com.vikramsingh.accounts.dto.Loans;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Vikram Singh on 28-02-2024
 * @git <a href="https://github.com/VikramThory">...</a>
 */
@Component
public class LoansFallback implements LoansFeignClient {
    @Override
    public List<Loans> getLoansDetails(String correlationId, Customer customer) {
        return null;
    }
}
