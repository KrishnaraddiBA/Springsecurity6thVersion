package com.security.service;

import com.security.controller.UserPrincipal;
import com.security.entity.Users;
import com.security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users name1 = userRepo.findByUsername(username);
        if (name1==null){
            System.out.println("user not found!!");
            throw new UsernameNotFoundException("userNotFound!!");
        }
        return new UserPrincipal(name1);
    }
}
