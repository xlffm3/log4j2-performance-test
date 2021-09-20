package com.example.logging.log4j2.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@Service
public class LogService {

    public void log() {
        for (int i = 0; i < 10_000; i++) {
            log.info("info log");
        }
    }
}
