package com.service.demo.service;

import com.service.demo.entity.User;

public interface UserService {
    User create(String username, String password);
}
