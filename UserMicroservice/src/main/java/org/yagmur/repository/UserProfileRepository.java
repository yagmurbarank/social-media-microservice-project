package org.yagmur.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.yagmur.document.UserProfile;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
}
