package com.example.mercury.controllers;

import com.example.mercury.dto.ApiResponseDto;
import com.example.mercury.dto.UserResponseDto;
import com.example.mercury.service.HttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Value("${pageToken}")
    private String pageToken;
    @Value("${userToken}")
    private String userToken;
    @Value("${pageId}")
    private String pageId;
    @Value("${userId}")
    private String userId;
    private final HttpClient httpClient;

    public DemoController(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @GetMapping("/facebook")
    public String getInfoFromFacebookApi(){
        ApiResponseDto responseDto = httpClient.get("https://graph.facebook.com/" + pageId + "?method=GET&access_token=" + pageToken, ApiResponseDto.class);
        UserResponseDto userResponseDto = httpClient.get("https://graph.facebook.com/" + userId + "?access_token=" + userToken, UserResponseDto.class);
        return responseDto.getMessage() + "<br>" + userResponseDto.getName();
    }
}
