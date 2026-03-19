package org.yagmur.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.yagmur.document.UserProfile;
import org.yagmur.dto.reques.CreateUserRequestDto;
import org.yagmur.repository.UserProfileRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository repository;
    private  final CacheManager cacheManager;

    public void createUser(CreateUserRequestDto dto) {
        repository.save(UserProfile.builder()
                        .authId(dto.getAuthId())
                        .userName(dto.getUserName())
                        .email(dto.getEmail())
                .build());
    }

    public List<UserProfile> getAll() {
        return repository.findAll();
    }

    @Cacheable("upper-case")
    public String upperName(String name) {
        String result = name.toUpperCase();

        try{
            Thread.sleep(3000L);
        } catch (Exception e) {
            return result;
        }

        return result;
    }

    public  void clearCache(){
        cacheManager.getCache("upper-case").clear();
    }
}
