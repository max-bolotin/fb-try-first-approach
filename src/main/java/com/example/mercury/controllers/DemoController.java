package com.example.mercury.controllers;

import com.example.mercury.dto.PageResponseDto;
import com.example.mercury.dto.UserResponseDto;
import com.example.mercury.service.FacebookConnectionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Value("${key.pageId}")
    private String pageId;
    @Value("${key.userId}")
    private String userId;
    private final FacebookConnectionService facebookConnectionService;

    public DemoController(FacebookConnectionService facebookConnectionService) {
        this.facebookConnectionService = facebookConnectionService;
    }

    @GetMapping("/facebook")
    public String getInfoFromFacebookApi(){
        PageResponseDto responseDto = facebookConnectionService.GetApiResponseDto(pageId);
        UserResponseDto userResponseDto = facebookConnectionService.getUserResponseDto(userId);
        return responseDto.getMessage() + "<br>" + userResponseDto.getName();
    }
}
