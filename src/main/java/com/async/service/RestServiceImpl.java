package com.async.service;

import com.async.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Slf4j
@Service
public class RestServiceImpl implements RestService {

    private final RestTemplate restTemplate;

    @Value("${partner.url}")
    private String PARTNER_URL;

    @Value("${partner.path}")
    private String FIND_BY_NAME;

    @Override
    public void findByName(String name) {
        String url = String.format("%s/%s", PARTNER_URL, FIND_BY_NAME);
        try {
            String test = restTemplate.getForObject(url, String.class);
            log.info(test);

            ApiResponse apiResponse = restTemplate.getForObject(url, ApiResponse.class);
            log.info(apiResponse.toString());
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
