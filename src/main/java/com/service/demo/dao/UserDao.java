package com.service.demo.dao;

import com.service.demo.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author hejian
 */
@Mapper
@Repository
public interface UserDao {
    /**
     * 查找用户通过用户名
     *
     * @param username 用户名
     * @return 返回@{@code User}
     */
    User findByUserName(@Param("userName") String username);

    /**
     * 保存用户
     *
     * @param user 用户@{@code User}
     * @return 返回受影响行数
     */
    int save(@Param("user") User user);

    /**
     * 删除所有记录
     *
     * @return 返回受影响行数
     */
    int deleteAll();
}
