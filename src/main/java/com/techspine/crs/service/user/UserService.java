package com.techspine.crs.service.user;

import com.techspine.crs.entity.User;

public interface UserService {

    User findByEmail(String email);
}
