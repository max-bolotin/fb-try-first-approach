package com.example.mercury.service.impl;

import com.example.mercury.dto.PageResponseDto;
import com.example.mercury.dto.UserResponseDto;
import com.example.mercury.service.FacebookConnectionService;
import com.example.mercury.service.HttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FacebookConnectionServiceImpl implements FacebookConnectionService {
  @Value("${pageToken}")
  private String pageToken;
  @Value("${userToken}")
  private String userToken;
  @Value("${apiUri}")
  private String apiUri;
  @Value("${queryString}")
  private String queryString;
  private final HttpClient httpClient;

  public FacebookConnectionServiceImpl(HttpClient httpClient) {
    this.httpClient = httpClient;
  }
  @Override
  public PageResponseDto GetApiResponseDto(String pageId) {
    return httpClient.get(apiUri + pageId + queryString + pageToken, PageResponseDto.class);
  }

  @Override
  public UserResponseDto getUserResponseDto(String userId) {
    return httpClient.get(apiUri + userId + queryString + userToken, UserResponseDto.class);
  }
}
