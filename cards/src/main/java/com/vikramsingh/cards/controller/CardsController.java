package com.vikramsingh.cards.controller;

import com.vikramsingh.cards.model.Cards;
import com.vikramsingh.cards.model.Customer;
import com.vikramsingh.cards.repository.CardsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

	private final CardsRepository cardsRepository;

    public CardsController(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer) {
		List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
		if (cards != null) {
			return cards;
		} else {
			return null;
		}

	}

}
