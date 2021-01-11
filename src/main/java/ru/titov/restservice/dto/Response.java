package ru.titov.restservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.util.HashMap;

@Data
@JsonRootName(value = "data")
public class Response {

    @JsonProperty("type")
    private HashMap<String, String> type;
}



