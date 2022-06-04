package ru.flawden.exchangerates.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.flawden.exchangerates.exception.ValidationException;
import ru.flawden.exchangerates.service.CurrencyService;

@RestController
@RequestMapping("api/v1/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/gif")
    public String isGettingHigher(@RequestParam String code) {
        return currencyService.isGettingHigher(code);
    }
}