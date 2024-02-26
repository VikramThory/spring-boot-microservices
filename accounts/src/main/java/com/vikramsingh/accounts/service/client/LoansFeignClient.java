package com.vikramsingh.accounts.service.client;

import com.vikramsingh.accounts.dto.Customer;
import com.vikramsingh.accounts.dto.Loans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * @author Vikram Singh on 25-02-2024
 * @git <a href="https://github.com/VikramThory">...</a>
 */
@FeignClient("loans")
public interface LoansFeignClient {

    @GetMapping(value = "/myLoans")
    List<Loans> getLoansDetails(@RequestHeader("vikramthory-correlation-id") String correlationId, @RequestBody Customer customer);

}
