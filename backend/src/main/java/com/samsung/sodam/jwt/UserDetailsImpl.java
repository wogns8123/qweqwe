package com.samsung.sodam.jwt;

import com.samsung.sodam.db.entity.Member;
import com.samsung.sodam.db.entity.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private static final String ROLE_PREFIX = "ROLE_";
    private final Member member;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Role role = member.getRole();

        // role name test
        System.out.println("jwt / UserDetailsImpl - "+role.getRoleName());
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName());
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);

        return authorities;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}