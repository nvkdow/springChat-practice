package com.chatter.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class UserDto implements UserDetails {

    private String username;
    private String password;
    private String usermail;
    private boolean enabled;
    private String userAuth;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> auth = new ArrayList<>();
        auth.add(new SimpleGrantedAuthority(userAuth));
        return auth;
    }
    @Override
    public boolean isAccountNonExpired() { return true; }
    @Override
    public boolean isAccountNonLocked() { return true; }
    @Override
    public boolean isCredentialsNonExpired() { return true; }
    @Override
    public boolean isEnabled() { return enabled; }

    @Override
    public String getUsername() { return username; }
    @Override
    public String getPassword() { return password; }
    public String getUsermail() { return usermail; }
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
