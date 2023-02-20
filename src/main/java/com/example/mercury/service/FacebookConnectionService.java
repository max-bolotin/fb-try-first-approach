package com.example.mercury.service;

import com.example.mercury.dto.PageResponseDto;
import com.example.mercury.dto.UserResponseDto;

public interface FacebookConnectionService {
  public PageResponseDto GetApiResponseDto(String pageId);

  public UserResponseDto getUserResponseDto(String userId);
}
