package ru.titov.restservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.titov.restservice.dto.Response;
import ru.titov.restservice.feign.CurrencyFeignClient;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyFeignClient currencyFeignClient;

    public Response findAll() {
        return currencyFeignClient.getLatestQuotes();
    }
}
