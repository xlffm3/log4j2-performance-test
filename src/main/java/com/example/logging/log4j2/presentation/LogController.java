package com.example.logging.log4j2.presentation;

import com.example.logging.log4j2.application.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LogController {

    private final LogService logService;

    @GetMapping("/log")
    public String log() {
        logService.log();
        return "log";
    }
}
