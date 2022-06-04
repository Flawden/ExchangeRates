package ru.flawden.exchangerates.feign;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "currency", url = "${currency.url}")
public interface CurrencyFeignClient {

    @GetMapping("/historical/{date}.json")
    String getCurrencyByDate(@PathVariable String date, @RequestParam String app_id, @RequestParam String base, @RequestParam String symbols);

}
