package com.example.logging.log4j2.presentation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import io.restassured.RestAssured;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StopWatch;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LogControllerTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void logTest() {
        // given
        StopWatch stopWatch = new StopWatch("logger-test");

        // when
        stopWatch.start();
        for (int i = 0; i < 1; i++) {
            RestAssured.given()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/log")
                .then()
                .statusCode(200);
        }
        stopWatch.stop();

        // then
        System.out.println(stopWatch.prettyPrint());
    }
}
