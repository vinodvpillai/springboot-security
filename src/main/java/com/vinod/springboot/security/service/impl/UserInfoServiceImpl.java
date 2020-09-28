package com.vinod.springboot.security.service.impl;

import com.vinod.springboot.security.model.MyUserDetails;
import com.vinod.springboot.security.model.UserInfo;
import com.vinod.springboot.security.repository.UserInfoRepository;
import com.vinod.springboot.security.service.IUserInfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class UserInfoServiceImpl implements IUserInfoService, UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo getUserInfo(Long id) {
        log.trace("Request came to fetch the user information having id: {}",id);
        Optional<UserInfo> optionalUserInfo=userInfoRepository.findById(id);
        if(optionalUserInfo.isPresent()) {
            log.trace("User information found for id: {} and user details are: {}",id,optionalUserInfo.get());
            return optionalUserInfo.get();
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.trace("Request came to fetch the user information having username: {}",username);
        Optional<UserInfo> optionalUserInfo=userInfoRepository.findByUsername(username);
        if(optionalUserInfo.isPresent()) {
            UserDetails userDetails=new MyUserDetails(optionalUserInfo.get());
            log.trace("User information found for username: {} and set to UserDetails object.",username);
            return userDetails;
        }
        throw new UsernameNotFoundException("Invalid username or password.");
    }
}
