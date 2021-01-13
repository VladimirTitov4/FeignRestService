package ru.titov.restservice.feign;

import feign.Param;
import feign.RequestLine;
import ru.titov.restservice.dto.gif.ResponseDto;

public interface GifFeignClient {

    @RequestLine("GET ?api_key={apiKey}&tag={tag}")
    ResponseDto getRandomGif(@Param("apiKey") String apiKey, @Param("tag") String tag);
}
