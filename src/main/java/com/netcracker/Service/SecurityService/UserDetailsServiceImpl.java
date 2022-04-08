package com.netcracker.Service.SecurityService;

import com.netcracker.Entity.User;
import com.netcracker.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByNickname(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("Пользователь '%s' не найден", username));
        } else
            return new org.springframework.security.core.userdetails.User(user.getNickname(), user.getPassword(), Collections.singleton(getAuthorities("user")));
    }

    private SimpleGrantedAuthority getAuthorities(String role) {
        return new SimpleGrantedAuthority(role);
    }

}
