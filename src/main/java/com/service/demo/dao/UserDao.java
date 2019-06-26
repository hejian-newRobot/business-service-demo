package com.service.demo.dao;

import com.service.demo.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    User findByUserName(String username);

    int save(User user);

    int deleteAll();
}
