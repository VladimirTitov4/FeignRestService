package ru.titov.restservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.titov.restservice.dto.RubleCurrency;
import ru.titov.restservice.service.CurrencyService;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final CurrencyService currencyService;

    @GetMapping("/")
    public RubleCurrency getRates() {
        return currencyService.findLatestRubleValue();
    }
}
