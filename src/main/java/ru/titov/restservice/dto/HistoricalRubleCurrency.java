package ru.titov.restservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class HistoricalRubleCurrency {

    private Double rubleValue;

    @JsonProperty("rates")
    private void unpackNested(Map<String, Double> rate) {
        this.rubleValue = rate.get("RUB");
    }
}
