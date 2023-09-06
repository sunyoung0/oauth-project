package com.sun.oauthback.service;

import org.springframework.http.ResponseEntity;

import com.sun.oauthback.dto.request.auth.SignUpRequestDto;
import com.sun.oauthback.dto.response.auth.SignUpResponseDto;

public interface AuthService {
	
	ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);

}
