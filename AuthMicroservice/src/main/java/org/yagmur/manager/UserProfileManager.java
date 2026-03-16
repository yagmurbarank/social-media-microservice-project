package org.yagmur.manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.yagmur.dto.request.CreateUserRequestDto;

import static org.yagmur.config.LoginApiEndpoints.CREATE_USER;

@FeignClient(name = "user-profile-service", url = "${service.user-profile.url}")
public interface UserProfileManager {

    @PostMapping(CREATE_USER)
    void createUser(@RequestBody CreateUserRequestDto dto);

}
