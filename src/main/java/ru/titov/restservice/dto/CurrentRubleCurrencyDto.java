
package ru.titov.restservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class CurrentRubleCurrencyDto {
    @JsonProperty("timestamp")
    public Long timestamp;
    public String rubleValue;

    @JsonProperty("rates")
    private void unpackNested(Map<String, String> rate) {
        this.rubleValue = rate.get("RUB");
    }
}
