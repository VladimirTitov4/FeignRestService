package ru.titov.restservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.titov.restservice.dto.gif.Response;
import ru.titov.restservice.feign.GifFeignClient;

@Service
@RequiredArgsConstructor
public class GifService {

    @Value("${apiKey}")
    private String apiKey;

    private final GifFeignClient gifFeignClient;

    public Response getRandomGif(String tag) {
        return gifFeignClient.getRandomGif(apiKey, tag);
    }
}

