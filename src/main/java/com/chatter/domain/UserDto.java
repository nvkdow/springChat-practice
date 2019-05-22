package com.chatter.domain;

import org.springframework.stereotype.Repository;

@Repository
public class UserDto {

    private String username;
    private String password;
    private String usermail;
    private boolean enabled;
    private String userAuth;

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getUsermail() { return usermail; }
    public boolean isEnabled() { return enabled; }
    public String getUserAuth() { return userAuth; }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setUsermail(String usermail) { this.usermail = usermail; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    public void setUserAuth(String userAuth) { this.userAuth = userAuth; }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usermail='" + usermail + '\'' +
                ", enabled=" + enabled +
                ", userAuth='" + userAuth + '\'' +
                '}';
    }
}
