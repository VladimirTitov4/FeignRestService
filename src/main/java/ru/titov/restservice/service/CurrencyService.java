package ru.titov.restservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.titov.restservice.dto.CurrentRubleCurrency;
import ru.titov.restservice.dto.HistoricalRubleCurrency;
import ru.titov.restservice.feign.CurrencyFeignClient;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    @Value("${appId}")
    private String appId;

    private final CurrencyFeignClient currencyFeignClient;

    public CurrentRubleCurrency findLatestRubleValue() {
        return currencyFeignClient.getLatestQuotes(appId);
    }

    public HistoricalRubleCurrency findHistoricalRubleValue(LocalDate date) {
        return currencyFeignClient.getHistoricalQuotes(date, appId);
    }
}
