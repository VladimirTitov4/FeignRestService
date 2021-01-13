package ru.titov.restservice.config;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.titov.restservice.feign.CurrencyFeignClient;
import ru.titov.restservice.feign.GifFeignClient;

@Configuration
public class FeignConfig {

    @Value("https://openexchangerates.org/api")
    private String currencyUrl;

    @Value("https://api.giphy.com/v1/gifs/random")
    private String gifUrl;

    @Bean
    public CurrencyFeignClient currencyFeignClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(CurrencyFeignClient.class, currencyUrl);
    }

    @Bean
    public GifFeignClient gifFeignClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(GifFeignClient.class, gifUrl);
    }
}
