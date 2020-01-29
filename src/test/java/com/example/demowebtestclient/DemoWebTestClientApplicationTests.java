package com.example.demowebtestclient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class DemoWebTestClientApplicationTests {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void getTest() {
        WebTestClient.BodyContentSpec response = webTestClient.get()
                .uri("/test")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().jsonPath("$.test").isEqualTo("success");

        System.out.println(response.returnResult());
    }

    @Test
    void postTest() {
        Temp temp = new Temp();
        temp.setName("test");
        temp.setVal1("value1");
        temp.setVal2("value2");

        WebTestClient.BodyContentSpec response = webTestClient.post()
                .uri("/test")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(temp))
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().jsonPath("$.post").isEqualTo("success");

        System.out.println(response.returnResult());
    }

}
