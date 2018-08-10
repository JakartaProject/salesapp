package salesapp.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Long userId;

    private String userName;

    private String userMobile;

    private String userAccount;

    private String userPwd;

    private Integer userRole;

    private Long userUp;

    private Integer userStatus;

    private String mysoftUserCode;

    private Date ct;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Long getUserUp() {
        return userUp;
    }

    public void setUserUp(Long userUp) {
        this.userUp = userUp;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getMysoftUserCode() {
        return mysoftUserCode;
    }

    public void setMysoftUserCode(String mysoftUserCode) {
        this.mysoftUserCode = mysoftUserCode;
    }

    public Date getCt() {
        return ct;
    }

    public void setCt(Date ct) {
        this.ct = ct;
    }
}