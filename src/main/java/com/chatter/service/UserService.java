package com.chatter.service;

import com.chatter.domain.UserDto;
import com.chatter.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserDto getUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public void insertUser(UserDto user) {
        userMapper.insertUser(user);
    }

    public void updatePassword(String username, String password) {
        userMapper.updatePassword(username, password);
    }

    public void deleteUser(String username) {
        userMapper.deleteUser(username);
    }
}
