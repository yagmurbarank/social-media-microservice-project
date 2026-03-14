package org.yagmur.repository;

import org.yagmur.entity.Auth;

public interface AuthRepository extends MyGenericRepo<Auth, Long> {
    Boolean existsByUserNameAndPassword(String userName, String password);
}
