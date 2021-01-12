package ru.titov.restservice.dto.gif;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Images {
    @JsonProperty("downsized_large")
    public DownsizedLarge downsizedLarge;
}
