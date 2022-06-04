package ru.flawden.exchangerates;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.flawden.exchangerates.service.FeignService;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class ExchangeRatesApplicationTests {

    @Autowired
    private FeignService jsonUtil;

    @Test
    void someTest() {
        assertNotNull(jsonUtil.getRate(new Date(), "RUB"));
        assertEquals(2, 1+1);
    }

}
