package com.service.hi.servicehi.dto;

import com.service.hi.servicehi.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

//    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User create(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userDao.save(user);
    }
}
