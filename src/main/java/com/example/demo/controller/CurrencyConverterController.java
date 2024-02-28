package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConverterController {

    @GetMapping("/convert")
    public String convertCurrency(@RequestParam String from, @RequestParam String to, @RequestParam double amount) {
        double exchangeRate = exchangeRate(from, to);
        if (exchangeRate == -1) {
            return "Unsupported currency pair";
        }
        return "Convert result " + amount + " " + from + " to " + to + " = " + exchangeRate * amount;
    }

    private double exchangeRate(String from, String to)
    {
        if (from.equals("USD") && to.equals("EUR")) {
            return 0.926414;
        } else if (from.equals("EUR") && to.equals("USD")) {
            return 1.079;
        }
        else {
            return -1;
        }
    }
}
