package com.example.logtest.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(path = "/log")
@RestController
public class LogTest {

    @GetMapping
    public boolean logging() {
        log.info("get logging!");
        return true;
    }

}