package com.vikramsingh.loans.controller;

import com.vikramsingh.loans.model.Customer;
import com.vikramsingh.loans.model.Loans;
import com.vikramsingh.loans.repository.LoansRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

	private static final Logger logger = LoggerFactory.getLogger(LoansController.class);

	private final LoansRepository loansRepository;

    public LoansController(LoansRepository loansRepository) {
        this.loansRepository = loansRepository;
    }

    @PostMapping("/myLoans")
	public List<Loans> getLoansDetails(@RequestHeader("vikramthory-correlation-id") String correlationId, @RequestBody Customer customer) {
		logger.debug("VikramThory-correlation-id found: {}", correlationId);
		List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
		if (loans != null) {
			return loans;
		} else {
			return null;
		}

	}

}
