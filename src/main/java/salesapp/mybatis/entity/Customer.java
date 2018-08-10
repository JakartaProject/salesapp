package salesapp.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private Long customerId;

    private String customerName;

    private String customerMobile;

    private String customerSocialid;

    private Integer customerGender;

    private String customerEmail;

    private String customerAddress;

    private Integer status;

    private Integer associatedType;

    private Long associatedUserId;

    private Long firstUserId;

    private Date firstRecvTime;

    private Date lastCommentTime;

    private static final long serialVersionUID = 1L;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerSocialid() {
        return customerSocialid;
    }

    public void setCustomerSocialid(String customerSocialid) {
        this.customerSocialid = customerSocialid;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAssociatedType() {
        return associatedType;
    }

    public void setAssociatedType(Integer associatedType) {
        this.associatedType = associatedType;
    }

    public Long getAssociatedUserId() {
        return associatedUserId;
    }

    public void setAssociatedUserId(Long associatedUserId) {
        this.associatedUserId = associatedUserId;
    }

    public Long getFirstUserId() {
        return firstUserId;
    }

    public void setFirstUserId(Long firstUserId) {
        this.firstUserId = firstUserId;
    }

    public Date getFirstRecvTime() {
        return firstRecvTime;
    }

    public void setFirstRecvTime(Date firstRecvTime) {
        this.firstRecvTime = firstRecvTime;
    }

    public Date getLastCommentTime() {
        return lastCommentTime;
    }

    public void setLastCommentTime(Date lastCommentTime) {
        this.lastCommentTime = lastCommentTime;
    }
}