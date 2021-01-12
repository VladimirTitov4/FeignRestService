package ru.titov.restservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import ru.titov.restservice.dto.CurrentRubleCurrency;
import ru.titov.restservice.dto.gif.Data;
import ru.titov.restservice.dto.gif.DownsizedLarge;
import ru.titov.restservice.dto.gif.Images;
import ru.titov.restservice.dto.gif.Response;
import ru.titov.restservice.dto.HistoricalRubleCurrency;
import ru.titov.restservice.service.CurrencyService;
import ru.titov.restservice.service.GifService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final CurrencyService currencyService;
    private final GifService gifService;

    @GetMapping("/")
    public RedirectView getRates() {
        CurrentRubleCurrency currentRubleCurrency = currencyService.findLatestRubleValue();
        long timestamp = currentRubleCurrency.getTimestamp();
        LocalDate currentDate = Instant.ofEpochMilli(timestamp * 1000).atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("Дата текущего курса" + currentDate);
        System.out.println("Значение текущего курса" + currentRubleCurrency.getRubleValue());

        LocalDate previousDate = currentDate.minusDays(1);

        while (true) {
            HistoricalRubleCurrency historicalRubleValue = currencyService.findHistoricalRubleValue(previousDate);
            System.out.println("Значение исторического курса" + historicalRubleValue.getRubleValue());

            int compare = Double.compare(currentRubleCurrency.getRubleValue(), (historicalRubleValue.getRubleValue()));
            if (compare == 0) {
                previousDate = previousDate.minusDays(1);
            } else {
                if (compare == 1) {
                    System.out.println("За сегодня стал выше вчерашнего");
                    Response response = gifService.getRandomGif("rich");
                    Data data = response.getData();
                    Images images = data.getImages();
                    String url = images.downsizedLarge.url;
                    return new RedirectView(url);

                } else {
                    System.out.println("За сегодня стал ниже вчерашнего");
                    Response response = gifService.getRandomGif("broke");
                    Data data = response.getData();
                    Images images = data.getImages();
                    String url = images.downsizedLarge.url;
                    return new RedirectView(url);
                }
            }
        }
    }
}
