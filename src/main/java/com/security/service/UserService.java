package com.security.service;

import com.security.entity.Users;
import com.security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JWTService jwtService;


    //we need a authentication manager to authenticate from the db
    @Autowired
    private AuthenticationManager authmanager;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    public Users saveUser(Users user){
        String encode = encoder.encode(user.getPassword());
        user.setPassword(encode);
        Users save = userRepo.save(user);
        return save;
    }

    public String validateUser(Users user){

        Authentication authenticate = authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authenticate.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        return "fail";
    }
}
