package com.sun.oauthback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sun.oauthback.dto.request.auth.SignUpRequestDto;
import com.sun.oauthback.dto.response.ResponseDto;
import com.sun.oauthback.dto.response.auth.SignUpResponseDto;
import com.sun.oauthback.entity.UserEntity;
import com.sun.oauthback.repository.UserRepository;
import com.sun.oauthback.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor	// 필요한 의존성 외부에서 주입할 수 있도록
public class AuthServiceImplement implements AuthService {
	
	private final UserRepository userRepository;

	@Override
	public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {

		String id = dto.getId();
		try {

			boolean hasId = userRepository.existsById(id);
			if (hasId) return SignUpResponseDto.existedId();

			UserEntity userEntity = new UserEntity(dto);
			userRepository.save(userEntity);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}

		return SignUpResponseDto.success();
	}
	
}
