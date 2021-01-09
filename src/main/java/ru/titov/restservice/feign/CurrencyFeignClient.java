package ru.titov.restservice.feign;

import feign.RequestLine;
import ru.titov.restservice.dto.RubleCurrency;

public interface CurrencyFeignClient {

    @RequestLine("GET /latest.json?app_id=747d8d481fd94d658cfd9e5a0cdd288d")
    RubleCurrency getLatestQuotes();
}
