package com.sun.oauthback.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.oauthback.dto.request.auth.SignUpRequestDto;
import com.sun.oauthback.dto.response.auth.SignUpResponseDto;
import com.sun.oauthback.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;

	@PostMapping("/sign-up")
	public ResponseEntity<? super SignUpResponseDto> signUp(@RequestBody @Valid SignUpRequestDto requestBody) {
		ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
		return response;
	}
}
