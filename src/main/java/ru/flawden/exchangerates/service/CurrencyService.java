package ru.flawden.exchangerates.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class CurrencyService {

    private final FeignService feignService;

    public CurrencyService(FeignService feignService) {
        this.feignService = feignService;
    }

    public String isGettingHigher(String code) {
        Calendar cal = Calendar.getInstance();
        float todayCourse = Float.parseFloat(feignService.getRate(cal.getTime(), code));
        cal.add(Calendar.DAY_OF_MONTH, -1);
        float yesterdayCourse = Float.parseFloat(feignService.getRate(cal.getTime(), code));
        return feignService.getGif(todayCourse < yesterdayCourse);

    }
}
