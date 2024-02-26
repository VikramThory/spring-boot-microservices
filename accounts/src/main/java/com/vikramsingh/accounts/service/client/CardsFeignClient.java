package com.vikramsingh.accounts.service.client;

import com.vikramsingh.accounts.dto.Cards;
import com.vikramsingh.accounts.dto.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * @author Vikram Singh on 25-02-2024
 * @git <a href="https://github.com/VikramThory">...</a>
 */
@FeignClient("cards")
public interface CardsFeignClient {

    @GetMapping(value = "/myCards")
    List<Cards> getCardDetails(@RequestHeader("vikramthory-correlation-id") String correlationId, @RequestBody Customer customer);

}
