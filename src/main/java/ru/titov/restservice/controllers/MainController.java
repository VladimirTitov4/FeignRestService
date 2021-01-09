package ru.titov.restservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.titov.restservice.dto.Rates;
import ru.titov.restservice.dto.Response;
import ru.titov.restservice.service.CurrencyService;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final CurrencyService currencyService;

    @GetMapping("/")
    public Response getRates() {
        Response response = currencyService.findAll();

        Rates rates = response.getRates();

        System.out.println(rates.getRUB());

        return response;
    }
}
