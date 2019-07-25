package fs.service.business.demoservice.test.dto;

import fs.service.business.demoservice.test.entity.Jwt;
import fs.service.business.demoservice.test.entity.User;

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
                ", staff=" + user +
                '}';
    }
}
