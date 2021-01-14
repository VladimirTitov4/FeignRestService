package ru.titov.restservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.titov.restservice.service.CurrencyService;
import ru.titov.restservice.service.GifService;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @MockBean
    private CurrencyService currencyService;

    @MockBean
    private GifService gifService;

    @Test
    public void getUrlTest() {
        String url = currencyService.getUrl();
        Assert.assertTrue(url.contains("giphy.com/embed"));
    }
}
