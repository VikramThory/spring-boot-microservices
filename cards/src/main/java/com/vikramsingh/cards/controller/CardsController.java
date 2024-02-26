package com.vikramsingh.cards.controller;

import com.vikramsingh.cards.model.Cards;
import com.vikramsingh.cards.model.Customer;
import com.vikramsingh.cards.repository.CardsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

	private static final Logger logger = LoggerFactory.getLogger(CardsController.class);

	private final CardsRepository cardsRepository;

    public CardsController(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestHeader("vikramthory-correlation-id") String correlationId, @RequestBody Customer customer) {
		logger.debug("VikramThory-correlation-id found: {}", correlationId);
		List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
		if (cards != null) {
			return cards;
		} else {
			return null;
		}

	}

}
