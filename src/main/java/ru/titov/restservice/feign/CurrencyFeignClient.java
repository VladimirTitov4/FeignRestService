package ru.titov.restservice.feign;

import feign.Param;
import feign.RequestLine;
import ru.titov.restservice.dto.CurrentRubleCurrencyDto;
import ru.titov.restservice.dto.HistoricalRubleCurrencyDto;

import java.time.LocalDate;

public interface CurrencyFeignClient {

    @RequestLine("GET /latest.json?app_id={appId}")
    CurrentRubleCurrencyDto getLatestQuotes(@Param("appId") String appId);

    @RequestLine("GET /historical/{date}.json?app_id={appId}")
    HistoricalRubleCurrencyDto getHistoricalQuotes(
            @Param("date") LocalDate date,
            @Param("appId") String appId);
}
