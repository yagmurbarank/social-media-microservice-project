package org.yagmur.service;

import lombok.RequiredArgsConstructor;
import org.yagmur.dto.request.CreateUserRequestDto;
import org.yagmur.dto.request.RegisterRequestDto;
import org.yagmur.dto.response.LoginResponseDto;
import org.yagmur.entity.Auth;
import org.yagmur.manager.UserProfileManager;
import org.yagmur.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private  final AuthRepository repository;
    private  final UserProfileManager userProfileManager;

    public  Auth register(RegisterRequestDto dto){
        Auth auth = repository.save(Auth.builder()
                        .userName(dto.getUsername())
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                .build());
        userProfileManager.createUser(CreateUserRequestDto.builder()
                         .authId(auth.getId())
                        .email(auth.getEmail())
                        .userName(auth.getUserName())
                .build());

        return auth;
    }

    public Boolean login(LoginResponseDto dto) {
        return repository.existsByUserNameAndPassword(dto.getUserName(), dto.getPassword());
    }
}
