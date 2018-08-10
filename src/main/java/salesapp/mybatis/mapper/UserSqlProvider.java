package salesapp.mybatis.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import salesapp.mybatis.entity.User;

public class UserSqlProvider {

    public String insertSelective(User record) {
        BEGIN();
        INSERT_INTO("user");
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserMobile() != null) {
            VALUES("user_mobile", "#{userMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getUserAccount() != null) {
            VALUES("user_account", "#{userAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPwd() != null) {
            VALUES("user_pwd", "#{userPwd,jdbcType=VARCHAR}");
        }
        
        if (record.getUserRole() != null) {
            VALUES("user_role", "#{userRole,jdbcType=INTEGER}");
        }
        
        if (record.getUserUp() != null) {
            VALUES("user_up", "#{userUp,jdbcType=BIGINT}");
        }
        
        if (record.getUserStatus() != null) {
            VALUES("user_status", "#{userStatus,jdbcType=INTEGER}");
        }
        
        if (record.getMysoftUserCode() != null) {
            VALUES("mysoft_user_code", "#{mysoftUserCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCt() != null) {
            VALUES("ct", "#{ct,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(User record) {
        BEGIN();
        UPDATE("user");
        
        if (record.getUserName() != null) {
            SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserMobile() != null) {
            SET("user_mobile = #{userMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getUserAccount() != null) {
            SET("user_account = #{userAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPwd() != null) {
            SET("user_pwd = #{userPwd,jdbcType=VARCHAR}");
        }
        
        if (record.getUserRole() != null) {
            SET("user_role = #{userRole,jdbcType=INTEGER}");
        }
        
        if (record.getUserUp() != null) {
            SET("user_up = #{userUp,jdbcType=BIGINT}");
        }
        
        if (record.getUserStatus() != null) {
            SET("user_status = #{userStatus,jdbcType=INTEGER}");
        }
        
        if (record.getMysoftUserCode() != null) {
            SET("mysoft_user_code = #{mysoftUserCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCt() != null) {
            SET("ct = #{ct,jdbcType=TIMESTAMP}");
        }
        
        WHERE("user_id = #{userId,jdbcType=BIGINT}");
        
        return SQL();
    }
}