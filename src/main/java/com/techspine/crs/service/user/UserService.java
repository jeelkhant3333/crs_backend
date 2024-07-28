package com.techspine.crs.service.user;

import com.techspine.crs.entity.User;

import java.util.Optional;

public interface UserService {

    User findByEmail(String email);
    User findUserByJwt(String jwt) throws Exception;

    void updateUserById(Integer userId,User user);
    void deleteUserById(Integer userId);
}
