package ru.titov.restservice.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConverterUtil {

    public Double getParsedDouble(String currencyValue) {
        if (currencyValue.contains(",")) {
            String replacedRubleValue = currencyValue.replaceAll(",", ".");
            return Double.parseDouble(replacedRubleValue);
        } else {
            return Double.parseDouble(currencyValue);
        }
    }
}
