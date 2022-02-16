package com.example.logtest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    void sleuthLogging() {
        log.info("sleuthLogging!!");
    }

}
