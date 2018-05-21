package com.patrickzinner.demo.basicauthbackend.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * This enum represents the user's authorities. We need this for {@link UserDetails#getAuthorities()}.
 * Since this should be a simple demo, only one authority exists and it's statically returned in the {@link User} class
 *
 */
public enum Roles implements GrantedAuthority{
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
