package com.vikramsingh.gatewayserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Vikram Singh on 28-02-2024
 * @git <a href="https://github.com/VikramThory">...</a>
 */
@RestController
public class FallbackController {

    @RequestMapping("contactSupport")
    public Mono<String> contactSupport() {
        return Mono.just("An error occurred. Please try after some time or contact support team!!!");
    }

}
