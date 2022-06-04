package ru.flawden.exchangerates.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
class CurrencyServiceTest {

    @Autowired
    private FeignService feignService;

    @Test
    void isJsonUtilExists() {
        assertThat(feignService).isNotNull();
    }

    @Test
    void today() {
        assertThat(feignService.getRate(new Date(), "RUB")).isNotNull();
    }

    @Test
    void yesterday() {
        assertThat(feignService.getRate(new Date(), "RUB")).isNotNull();
    }

    @Test
    void isGettingHigher() {
        assertThat(feignService.getGif(true)).isNotNull();
        assertThat(feignService.getGif(false)).isNotNull();
    }
}