package com.async.controller;

import com.async.service.RestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/tests")
public class TestController {

    private final RestService restService;

    @RequestMapping(value = "/")
    public String execute(@RequestParam("name") String name) {
        restService.findByName(name);
//
//        log.info("Start Execute API in thread: {}", Thread.currentThread().getName());
//        CompletableFuture.runAsync(() -> {
//            log.info("Start Call Async API in thread: {}", Thread.currentThread().getName());
//            restService.findByName(name);
//        });

        return "OK";
    }
}
