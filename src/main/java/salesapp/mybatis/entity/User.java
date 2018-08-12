package salesapp.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String userId;

    private String userName;

    private String userMobile;

    private String userPosition;

    private String userAccount;

    private String userPwd;

    private String userInitPwd;

    private Integer userRole;

    private String userUp;

    private Integer userStatus;

    private String userRemark;

    private String mysoftUserCode;

    private Date ct;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
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

    public String getUserInitPwd() {
        return userInitPwd;
    }

    public void setUserInitPwd(String userInitPwd) {
        this.userInitPwd = userInitPwd;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public String getUserUp() {
        return userUp;
    }

    public void setUserUp(String userUp) {
        this.userUp = userUp;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
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