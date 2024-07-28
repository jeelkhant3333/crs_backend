package com.techspine.crs.service.user;

import com.techspine.crs.entity.User;
import com.techspine.crs.repository.UserRepository;
import com.techspine.crs.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByJwt(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromJwt(jwt);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("User Not Found");
        }
        return user;
    }

    @Override
    public void updateUserById(Integer userId, User user) {
        Optional<User> isUser = userRepository.findById(userId);
        if (isUser.isPresent()) {
            User updateUser = isUser.get();
            updateUser.setFirstName(user.getFirstName());
            updateUser.setLastName(user.getLastName());
            updateUser.setEmail(user.getEmail());
            updateUser.setProfileImg(user.getProfileImg());
                    userRepository.save(updateUser);

        } else {
            throw new RuntimeException("User Not Found With Id= " + userId);
        }
    }

    @Override
    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }


}
