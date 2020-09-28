package com.vinod.springboot.security.service;

import com.vinod.springboot.security.model.UserInfo;

public interface IUserInfoService {
    /**
     * Get User information base on the id.
     *
     * @param id - User ID.
     * @return - UserInfo object.
     */
    public UserInfo getUserInfo(Long id);
}
