package ru.flawden.exchangerates.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.flawden.exchangerates.feign.CurrencyFeignClient;
import ru.flawden.exchangerates.feign.GifFeignClient;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class FeignService {

    private final CurrencyFeignClient currencyFeignClient;
    private final GifFeignClient gifFeignClient;

    @Value("${currency.api.key}")
    private String currencyApiId;

    @Value("${gif.api.key}")
    private String gifApiId;

    @Value("${base.currency}")
    private String base;

    public FeignService(CurrencyFeignClient currencyFeignClient, GifFeignClient gifFeignClient) {
        this.currencyFeignClient = currencyFeignClient;
        this.gifFeignClient = gifFeignClient;
    }

    public String getRate(Date date, String code) {
        code = code.toUpperCase(Locale.ROOT);
        ObjectMapper mapper = new ObjectMapper();
        try {
            SimpleDateFormat currencyDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            JsonNode node = mapper.readTree(currencyFeignClient.getCurrencyByDate(currencyDateFormat.format(date), currencyApiId, base, code));
            return node.get("rates").get(code).asText();

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public String getGif(boolean isHigher) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node;
            if (isHigher) {
                node = mapper.readTree(gifFeignClient.getRandomRichGif(gifApiId, "rich"));
            } else {
                node = mapper.readTree(gifFeignClient.getRandomBrokeGif(gifApiId, "broke"));
            }
            return node.get("data").get("images").get("downsized_medium").get("url").asText();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
