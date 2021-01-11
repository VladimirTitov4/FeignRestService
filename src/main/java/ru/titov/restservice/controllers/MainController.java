package ru.titov.restservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.titov.restservice.dto.CurrentRubleCurrency;
import ru.titov.restservice.dto.Response;
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
    public Response getRates() {
        return gifService.getRandomGif("broke");







//        CurrentRubleCurrency currentRubleCurrency = currencyService.findLatestRubleValue();
//        long timestamp = currentRubleCurrency.getTimestamp();
//        LocalDate currentDate = Instant.ofEpochMilli(timestamp * 1000).atZone(ZoneId.systemDefault()).toLocalDate();
//        System.out.println("Дата текущего курса" + currentDate);
//        System.out.println("Значение текущего курса" + currentRubleCurrency.getRubleValue());
//
//        LocalDate previousDate = currentDate.minusDays(1);
//
//        while (true) {
//            HistoricalRubleCurrency historicalRubleValue = currencyService.findHistoricalRubleValue(previousDate);
//            System.out.println("Значение исторического курса" + historicalRubleValue.getRubleValue());
//
//            int compare = Double.compare(currentRubleCurrency.getRubleValue(), (historicalRubleValue.getRubleValue()));
//            if (compare == 0) {
//                previousDate = previousDate.minusDays(1);
//            } else {
//                if (compare == 1) {
//                    System.out.println("За сегодня стал выше вчерашнего");
//                    return gifService.getRandomGif("rich");
//                } else {
//                    System.out.println("За сегодня стал ниже вчерашнего");
//                    return gifService.getRandomGif("broke");
//                }
//            }
//        }
    }
}
