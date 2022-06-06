package ru.flawden.exchangerates.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class FeignServiceTest {

    @Autowired
    private FeignService feignService;

    @Test
    void isJsonUtilExists() {
        assertThat(feignService).isNotNull();
    }

    @Test
    void getGif() {
        assertThat(feignService.getRate(new Date(), "RUB")).isNotNull();
        assertThat(feignService.getRate(new Date(), "USD")).isNotNull();
    }

    @Test
    void getRate() {
        assertThat(feignService.getGif(true)).isNotNull();
        assertThat(feignService.getGif(false)).isNotNull();
    }
}