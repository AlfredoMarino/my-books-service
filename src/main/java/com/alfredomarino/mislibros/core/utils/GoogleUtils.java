package com.alfredomarino.mislibros.core.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * GoogleUtils
 */
public class GoogleUtils {

    public static final String GOOGLEBOOKS_URL_BASE = "https://www.googleapis.com/books";

    public static String searchVolume(String searchText) throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(GOOGLEBOOKS_URL_BASE + "/v1/volumes?q=la mala hora", String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode name = root.path("totalItems");

        return name.asText();
    }
}