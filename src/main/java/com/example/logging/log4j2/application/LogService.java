package com.example.logging.log4j2.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@Service
public class LogService {

    @Async
    public void log() {
        for (int i = 0; i < 100_000; i++) {
            log.info("info log");
        }
    }
}
