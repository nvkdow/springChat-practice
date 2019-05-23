package com.chatter.service;

import com.chatter.domain.UserDto;
import com.chatter.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {
        UserDto user = userMapper.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    public String getHashedPassword(String username, String password) {
        return userMapper.getHashedPassword(username, password);
    }

    public void registerUser(UserDto user){ userMapper.insertUser(user); }

    public void updatePassword(String username, String password) {
        userMapper.updatePassword(username, password);
    }

    public void deleteUser(String username) {
        userMapper.deleteUser(username);
    }
}
