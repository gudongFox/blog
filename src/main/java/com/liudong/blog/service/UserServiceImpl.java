package com.liudong.blog.service;

import com.liudong.blog.dao.UserRepository;
import com.liudong.blog.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User checkUser(String username, String password) {

        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User checkUser(String username){


        return userRepository.findByUsername(username);
    }

    @Override
    public User saveUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }


}
