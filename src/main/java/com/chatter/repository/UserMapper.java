package com.chatter.repository;

import com.chatter.domain.UserDto;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT username, password, usermail, enabled, userAuth FROM users WHERE username = #{username}")
    UserDto findByUsername(@Param("username") String username);

    @Select("SELECT SHA1(CONCAT(salt_value, #{password})) FROM users WHERE username = #{username}")
    String getHashedPassword(@Param("username") String username, @Param("password") String password);

    @Insert("INSERT INTO users(username, salt_value, password, usermail) VALUES(#{username}, SUBSTRING(RAND(), 1, 7), SHA1(CONCAT(salt_value, #{password})), #{usermail})")
    void insertUser(UserDto user);

    @Update("UPDATE users SET password = SHA1(CONCAT(salt_value, #{password})) WHERE username = #{username}")
    void updatePassword(@Param("username") String username, @Param("password") String password);

    @Delete("DELETE FROM users WHERE username = #{username}")
    void deleteUser(@Param("username") String username);
}
