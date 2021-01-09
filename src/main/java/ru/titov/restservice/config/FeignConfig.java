package ru.titov.restservice.config;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.titov.restservice.feign.CurrencyFeignClient;

@Configuration
public class FeignConfig {

    @Value("https://openexchangerates.org/api")
    private String latestUrl;

    @Bean
    public CurrencyFeignClient currencyFeignClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(CurrencyFeignClient.class, latestUrl);
    }
}
