package com.alfredomarino.mybooks.core.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * GoogleUtils
 */
public class GoogleUtils {

    public static final String GOOGLEBOOKS_URL_BASE = "https://www.googleapis.com/books";
    public static final String GOOGLEBOOKS_URL_VOLUMES = "/v1/volumes";

    public static JsonNode searchVolumeByAnyText(String anyText) {
        String url = "?q=" + anyText;
        return searchVolume(url);
    }

    public static JsonNode searchVolumeByGoogleId(String googleId) {
        return searchVolume("/" + googleId);
    }

    private static JsonNode searchVolume(String query) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        String url = GOOGLEBOOKS_URL_BASE + GOOGLEBOOKS_URL_VOLUMES + query;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        try {
            root = mapper.readTree(response.getBody());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}