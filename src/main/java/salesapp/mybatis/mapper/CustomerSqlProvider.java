package salesapp.mybatis.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import salesapp.mybatis.entity.Customer;

public class CustomerSqlProvider {

    public String insertSelective(Customer record) {
        BEGIN();
        INSERT_INTO("customer");
        
        if (record.getCustomerId() != null) {
            VALUES("customer_id", "#{customerId,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerName() != null) {
            VALUES("customer_name", "#{customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerMobile() != null) {
            VALUES("customer_mobile", "#{customerMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerSocialid() != null) {
            VALUES("customer_socialid", "#{customerSocialid,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerGender() != null) {
            VALUES("customer_gender", "#{customerGender,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerEmail() != null) {
            VALUES("customer_email", "#{customerEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerAddress() != null) {
            VALUES("customer_address", "#{customerAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getAssociatedType() != null) {
            VALUES("associated_type", "#{associatedType,jdbcType=INTEGER}");
        }
        
        if (record.getAssociatedUserId() != null) {
            VALUES("associated_user_id", "#{associatedUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getFirstUserId() != null) {
            VALUES("first_user_id", "#{firstUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getFirstRecvTime() != null) {
            VALUES("first_recv_time", "#{firstRecvTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastCommentTime() != null) {
            VALUES("last_comment_time", "#{lastCommentTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Customer record) {
        BEGIN();
        UPDATE("customer");
        
        if (record.getCustomerName() != null) {
            SET("customer_name = #{customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerMobile() != null) {
            SET("customer_mobile = #{customerMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerSocialid() != null) {
            SET("customer_socialid = #{customerSocialid,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerGender() != null) {
            SET("customer_gender = #{customerGender,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerEmail() != null) {
            SET("customer_email = #{customerEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerAddress() != null) {
            SET("customer_address = #{customerAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getAssociatedType() != null) {
            SET("associated_type = #{associatedType,jdbcType=INTEGER}");
        }
        
        if (record.getAssociatedUserId() != null) {
            SET("associated_user_id = #{associatedUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getFirstUserId() != null) {
            SET("first_user_id = #{firstUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getFirstRecvTime() != null) {
            SET("first_recv_time = #{firstRecvTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastCommentTime() != null) {
            SET("last_comment_time = #{lastCommentTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("customer_id = #{customerId,jdbcType=VARCHAR}");
        
        return SQL();
    }
}