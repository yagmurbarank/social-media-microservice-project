package org.yagmur.service;

import lombok.RequiredArgsConstructor;
import org.yagmur.dto.request.RegisterRequestDto;
import org.yagmur.dto.response.LoginResponseDto;
import org.yagmur.entity.Auth;
import org.yagmur.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private  final AuthRepository repository;

    public  Auth register(RegisterRequestDto dto){
        return  repository.save(Auth.builder()
                        .userName(dto.getUsername())
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                .build());
    }

    public Boolean login(LoginResponseDto dto) {
        return repository.existsByUserNameAndPassword(dto.getUserName(), dto.getPassword());
    }
}
