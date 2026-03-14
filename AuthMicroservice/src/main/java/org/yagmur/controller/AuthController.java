package org.yagmur.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yagmur.dto.request.RegisterRequestDto;
import org.yagmur.dto.response.LoginResponseDto;
import org.yagmur.entity.Auth;
import org.yagmur.service.AuthService;

import static org.yagmur.config.RestApi.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)
public class AuthController {
    private  final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto dto){
       if(!dto.getPassword().equals(dto.getRepassword()))
           throw new RuntimeException("Passwords does not match.");

       return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping(LOGIN)
    public  ResponseEntity<Boolean> login(@RequestBody LoginResponseDto dto){
        return ResponseEntity.ok(authService.login(dto));

    }
}
