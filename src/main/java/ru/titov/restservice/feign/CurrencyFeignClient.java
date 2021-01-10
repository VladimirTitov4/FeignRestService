package ru.titov.restservice.feign;

import feign.Param;
import feign.RequestLine;
import ru.titov.restservice.dto.CurrentRubleCurrency;
import ru.titov.restservice.dto.HistoricalRubleCurrency;

import java.time.LocalDate;

public interface CurrencyFeignClient {

    @RequestLine("GET /latest.json?app_id={appId}")
    CurrentRubleCurrency getLatestQuotes(@Param("appId") String appId);

    @RequestLine("GET /historical/{date}.json?app_id={appId}")
    HistoricalRubleCurrency getHistoricalQuotes(
            @Param("date") LocalDate date,
            @Param("appId") String appId);
}
