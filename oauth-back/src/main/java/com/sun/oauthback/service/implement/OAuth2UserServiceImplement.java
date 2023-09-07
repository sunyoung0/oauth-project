package com.sun.oauthback.service.implement;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.sun.oauthback.entity.ApplicationOAuth2User;
import com.sun.oauthback.entity.UserEntity;
import com.sun.oauthback.repository.UserRepository;

import lombok.RequiredArgsConstructor;

// import com.fasterxml.jackson.databind.ObjectMapper;

@Service@RequiredArgsConstructor
public class OAuth2UserServiceImplement extends DefaultOAuth2UserService {

	private final UserRepository userRepository;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {

		OAuth2User oAuth2User = super.loadUser(request);		// DefaultOAuth2UserService 여기서 loadUser를 가져옴

		// try {
		// 	System.out.println(new ObjectMapper().writeValueAsString(oAuth2User.getAttributes()));
		// } catch (Exception exception) {
		// 	exception.printStackTrace();
		// }

		String id = (String) oAuth2User.getAttributes().get("login");		// object 타입을 String으로 다운캐스팅함
		String profileImage = (String) oAuth2User.getAttributes().get("avatar_url");

		boolean existedId = userRepository.existsById(id);
		if (!existedId) {
			UserEntity userEntity = new UserEntity(id, profileImage);
			userRepository.save(userEntity);
		}

		return new ApplicationOAuth2User(id, oAuth2User.getAttributes());
		
	}
	
}
