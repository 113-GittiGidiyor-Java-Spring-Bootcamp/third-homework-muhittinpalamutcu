package io.github.muhittinpalamutcu.schoolmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class CurrencyConversionController {
    //http://localhost:8090/api/currency-converter/usd?amount=400"
    private final static String endPoint = "http://localhost:8090/api/currency-converter";

    @Autowired
    RestTemplate restTemplate;

    // @desc Convert currency by making a request to converter API
    // @route Get /currencyConvert/{currency}/{amount}
    // @access Public
    @GetMapping("/currency-convert/{currency}/{amount}")
    public String convertCurrency(@PathVariable String currency, @PathVariable int amount) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(endPoint + "/" + currency + "?" + "amount" + "=" + amount, String.class);
        return responseEntity.getBody();
    }
}
