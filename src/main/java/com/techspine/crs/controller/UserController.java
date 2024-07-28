package com.techspine.crs.controller;

import com.techspine.crs.entity.User;
import com.techspine.crs.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @GetMapping("")
    public ResponseEntity<User> findUserByJwt(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userServiceImpl.findUserByJwt(jwt);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable Integer userId,@RequestBody()User reqUser) throws Exception {
        userServiceImpl.updateUserById(userId, reqUser);
        return "User Updated Successfully...";
    }

    @DeleteMapping("/{userId}")
    public String deleteUserById(@PathVariable Integer userId,@RequestHeader("Authorization")String jwt) throws Exception {
        User user = userServiceImpl.findUserByJwt(jwt);
        if (userId == user.getUserId()) {
        userServiceImpl.deleteUserById(userId);
        return "User Deleted Successfully...";
        }else {
            return "User Id " +userId+ " is not matching according request.";
        }
    }


}
