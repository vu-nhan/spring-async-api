package com.async.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class RestServiceImpl implements RestService {

    private static final List<String> DATA_LIST = new ArrayList<>();

    private final RestTemplate restTemplate;

    @Value("${partner.url}")
    private String PARTNER_URL;

    @Value("${partner.path}")
    private String FIND_BY_NAME;

    @Override
    public void findByName(String name) {
        String url = String.format("%s/%s", PARTNER_URL, FIND_BY_NAME);
        try {
            String response = restTemplate.getForObject(url, String.class);
            log.info("FindByName successfully with response: {}", response);

            DATA_LIST.add(response);
        } catch (Exception ex) {
            log.info("FindByName failed with error: {}", ex.getMessage());
        }
    }
}
