package com.alfredomarino.mybooks.core.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * GoogleUtils
 */
public class GoogleUtils {

    public static final String GOOGLEBOOKS_URL_BASE = "https://www.googleapis.com/books";

    public static JsonNode searchVolume(String searchText) throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(GOOGLEBOOKS_URL_BASE + "/v1/volumes?q=" + searchText, String.class);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(response.getBody());
    }
}