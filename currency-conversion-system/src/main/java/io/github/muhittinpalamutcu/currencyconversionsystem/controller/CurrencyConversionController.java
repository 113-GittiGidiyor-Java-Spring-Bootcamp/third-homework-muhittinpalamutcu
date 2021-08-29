package io.github.muhittinpalamutcu.currencyconversionsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class CurrencyConversionController {

    // @desc Convert currency by query
    // @route Get /currency-converter/{currency}?amount=100
    // @access Public
    @GetMapping("/currency-converter/{currency}")
    public ResponseEntity<String> converter(@PathVariable String currency, @PathParam("amount") int amount) {
        if (currency.equals("usd")) {
            return new ResponseEntity<>(amount + " USD equals to : " + amount * 8.35 + " TL", HttpStatus.OK);
        } else if (currency.equals("tl")) {
            return new ResponseEntity<>(amount + " TL equals to : " + amount * 0.12 + " USD", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
