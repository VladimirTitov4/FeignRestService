package ru.titov.restservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.titov.restservice.dto.CurrentRubleCurrencyDto;
import ru.titov.restservice.dto.HistoricalRubleCurrencyDto;
import ru.titov.restservice.feign.CurrencyFeignClient;
import ru.titov.restservice.util.ConverterUtil;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    @Value("${appId}")
    private String appId;

    private final CurrencyFeignClient currencyFeignClient;
    private final GifService gifService;

    public String getUrl() {
        CurrentRubleCurrencyDto currentRubleCurrency = currencyFeignClient.getLatestQuotes(appId);
        String rawCurrentRubleValue = currentRubleCurrency.getRubleValue();
        LocalDate currentDate = Instant.ofEpochMilli(currentRubleCurrency.getTimestamp() * 1000).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate previousDate = currentDate.minusDays(1);
        HistoricalRubleCurrencyDto historicalRubleValue = currencyFeignClient.getHistoricalQuotes(previousDate, appId);
        String rawHistoricalRubleValue = historicalRubleValue.getRubleValue();
        int compare = Double.compare(ConverterUtil.getParsedDouble(rawCurrentRubleValue), (ConverterUtil.getParsedDouble(rawHistoricalRubleValue)));
        if (compare == 1) {
            return gifService.getRandomGif("rich").getDataDto().getUrl();
        } else {
            return gifService.getRandomGif("broke").getDataDto().getUrl();
        }
    }

    public String getIframe() {
        String url = getUrl();
        return String.format("<iframe src=\"%s\" width=\"480\" height=\"270\" frameBorder=\"0\" class=\"giphy-embed\" allowFullScreen></iframe>", url);
    }
}
