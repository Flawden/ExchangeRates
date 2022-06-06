package ru.flawden.exchangerates.util;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import ru.flawden.exchangerates.exception.ValidationException;

import java.util.Locale;
import java.util.regex.Pattern;

@Component
public class ValidationUtil {

    public void validateCode(String code) {
        if (code.length() != 3) {
            throw new ValidationException("The value does not match the length of 3 characters");
        }
        if (!code.matches("[A-Za-z]+")) {
            throw new ValidationException("The code can only contain Latin characters");
        }
    }

    public void isCurrencyExists(JsonNode currency) {
        if(currency == null) {
            throw new ValidationException("Incorrect currency value");
        }
    }

}
