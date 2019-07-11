package fs.service.business.demoservice.test.entity;

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

    private String username;

    private String pwd;

    private String fsRole;

    public final String getUsername() {
        return username;
    }

    public final void setUsername(String username) {
        this.username = username;
    }

    public final String getPwd() {
        return pwd;
    }

    public final void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public final String getFsRole() {
        return fsRole;
    }

    public final void setFsRole(String fsRole) {
        this.fsRole = fsRole;
    }
}
