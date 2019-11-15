package com.liudong.blog.service;

import com.liudong.blog.po.User;

public interface UserService {

    User checkUser(String username, String password);
    User checkUser(String username);
    User saveUser(String username, String password);

}
