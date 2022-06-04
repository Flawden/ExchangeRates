package ru.flawden.exchangerates.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gif", url = "${gif.url}")
public interface GifFeignClient {

    @GetMapping("random")
    public String getRandomBrokeGif(@RequestParam String api_key, @RequestParam String tag);

    @GetMapping("random")
    public String getRandomRichGif(@RequestParam String api_key, @RequestParam String tag);

}
