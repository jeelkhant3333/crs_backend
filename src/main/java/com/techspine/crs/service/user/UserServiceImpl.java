package com.techspine.crs.service.user;

import com.techspine.crs.entity.User;
import com.techspine.crs.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
