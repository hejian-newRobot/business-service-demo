package com.service.demo.test.entity;

/**
 * 项目名称：SimpleSpringCloudGateway
 * 包名称:com.learn.user.po
 * 类描述：
 * 创建人：hejian
 * 创建时间：2019/6/20 10:13
 * 修改人：hejian
 * 修改时间：2019/6/20 10:13
 * 修改备注：
 *
 * @author hejian
 */

/**
 * 账户实体类
 *
 * @author hejian
 */
public class User {

    /**
     * 主键
     */
    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 角色
     */
    private String roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
