package ru.titov.restservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class HistoricalRubleCurrencyDto {

    public String rubleValue;

    @JsonProperty("rates")
    public void unpackNested(Map<String, String> rate) {
        this.rubleValue = rate.get("RUB");
    }
}
