package org.yagmur.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yagmur.document.UserProfile;
import org.yagmur.dto.reques.CreateUserRequestDto;
import org.yagmur.service.UserProfileService;

import static org.yagmur.config.UserApiEndpoints.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER_PROFILE)
public class UserProfileController {
    private  final UserProfileService userProfileService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto){
        userProfileService.createUser(dto);
        return  ResponseEntity.ok(true);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getAll(){
      return  ResponseEntity.ok(userProfileService.getAll());
    }

    @GetMapping("/upper-name")
    public ResponseEntity<String> upperName(String name){
        return ResponseEntity.ok(userProfileService.upperName(name));
    }
}
