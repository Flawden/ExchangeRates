package ru.flawden.exchangerates.service;

import org.springframework.stereotype.Service;
import ru.flawden.exchangerates.util.ValidationUtil;

import java.util.Calendar;

@Service
public class CurrencyService {

    private final FeignService feignService;
    private final ValidationUtil validationUtil;

    public CurrencyService(FeignService feignService, ValidationUtil validationUtil) {
        this.feignService = feignService;
        this.validationUtil = validationUtil;
    }

    public String isGettingHigher(String code) {
        code = validationUtil.validateCode(code);
        Calendar cal = Calendar.getInstance();
        float todayCourse = Float.parseFloat(feignService.getRate(cal.getTime(), code));
        cal.add(Calendar.DAY_OF_MONTH, -1);
        float yesterdayCourse = Float.parseFloat(feignService.getRate(cal.getTime(), code));
        return feignService.getGif(todayCourse < yesterdayCourse);

    }
}
