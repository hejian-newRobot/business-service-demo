package com.service.demo.dto;

import com.service.demo.entity.Jwt;
import com.service.demo.entity.User;

/**
 * @author hejian
 */
public class UserLoginDto {
    private Jwt jwt;
    private User user;

    public Jwt getJwt() {
        return jwt;
    }

    public void setJwt(Jwt jwt) {
        this.jwt = jwt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserLoginDto{" +
                "jwt=" + jwt +
                ", user=" + user +
                '}';
    }
}
