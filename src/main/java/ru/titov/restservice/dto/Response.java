
package ru.titov.restservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response {

    @JsonProperty("disclaimer")
    public String disclaimer;
    @JsonProperty("license")
    public String license;
    @JsonProperty("timestamp")
    public Integer timestamp;
    @JsonProperty("base")
    public String base;
    @JsonProperty("rates")
    public Rates rates;

}
