package com.apis.Fields_To_Future_Services.DTOs;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.apis.Fields_To_Future_Services.Entities.User;

public class UserInfoDetails implements UserDetails {

    private String contact;
    private String password;

    private List<GrantedAuthority> grantedAuthorities;

    public UserInfoDetails(String contact, String password, User user) {
        this.contact = contact;
        this.password = password;
        this.grantedAuthorities = user.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.getRolename()))
            .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        // Implement the logic to return the user's password
        return password;
    }

    @Override
    public String getUsername() {
        // Implement the logic to return the user's username (or contact)
        return contact;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implement the logic to check if the account is non-expired
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implement the logic to check if the account is non-locked
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implement the logic to check if the credentials are non-expired
        return false;
    }

    @Override
    public boolean isEnabled() {
        // Implement the logic to check if the account is enabled
        return false;
    }
}
