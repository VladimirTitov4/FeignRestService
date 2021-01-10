package ru.titov.restservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class HistoricalRubleCurrency {
    @JsonProperty("timestamp")
    private long timestamp;
    private Double rubleValue;

    @JsonProperty("rates")
    private void unpackNested(Map<String, Double> rate) {
        this.rubleValue = rate.get("RUB");
    }
}
