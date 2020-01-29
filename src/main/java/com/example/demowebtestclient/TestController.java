package com.example.demowebtestclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "{\"test\":\"success\"}";
    }

    @PostMapping("/test")
    public String test2(@RequestBody Temp temp) {
        log.debug(temp + "");
        return "{\"post\":\"success\"}";
    }
}
