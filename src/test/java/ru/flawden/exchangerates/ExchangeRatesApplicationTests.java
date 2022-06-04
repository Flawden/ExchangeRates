package ru.flawden.exchangerates;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.flawden.exchangerates.controller.CurrencyController;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class ExchangeRatesApplicationTests {

    @Test
    void someTest() {
        assertEquals(2, 1+1);
    }

}
