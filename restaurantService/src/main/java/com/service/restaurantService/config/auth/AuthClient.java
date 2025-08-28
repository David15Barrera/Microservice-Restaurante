package com.service.restaurantService.config.auth;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class AuthClient {

    private final RestTemplate rest = new RestTemplate();

    public String loginAndGetToken(String authUrl, Map<String,String> credentials){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String,String>> req = new HttpEntity<>(credentials, headers);
        ResponseEntity<Map> resp = rest.postForEntity(authUrl, req, Map.class);

        if(resp.getStatusCode().is2xxSuccessful() && resp.getBody()!=null){
            Object t = resp.getBody().get("access_token");
            if(t!=null) return t.toString();
            t = resp.getBody().get("token");
            if(t!=null) return t.toString();
        }
        return null;
    }
}
