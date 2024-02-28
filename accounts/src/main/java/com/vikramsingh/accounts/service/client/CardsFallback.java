package com.vikramsingh.accounts.service.client;

import com.vikramsingh.accounts.dto.Cards;
import com.vikramsingh.accounts.dto.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Vikram Singh on 28-02-2024
 * @git <a href="https://github.com/VikramThory">...</a>
 */
@Component
public class CardsFallback implements CardsFeignClient{

    @Override
    public List<Cards> getCardDetails(String correlationId, Customer customer) {
        return null;
    }
}
