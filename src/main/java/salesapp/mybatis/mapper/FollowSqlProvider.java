package salesapp.mybatis.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import salesapp.mybatis.entity.Follow;

public class FollowSqlProvider {

    public String insertSelective(Follow record) {
        BEGIN();
        INSERT_INTO("follow");
        
        if (record.getFollowId() != null) {
            VALUES("follow_id", "#{followId,jdbcType=BIGINT}");
        }
        
        if (record.getCustomerId() != null) {
            VALUES("customer_id", "#{customerId,jdbcType=BIGINT}");
        }
        
        if (record.getFollowUserId() != null) {
            VALUES("follow_user_id", "#{followUserId,jdbcType=BIGINT}");
        }
        
        if (record.getFollowType() != null) {
            VALUES("follow_type", "#{followType,jdbcType=INTEGER}");
        }
        
        if (record.getFollowContent() != null) {
            VALUES("follow_content", "#{followContent,jdbcType=VARCHAR}");
        }
        
        if (record.getFollowTime() != null) {
            VALUES("follow_time", "#{followTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Follow record) {
        BEGIN();
        UPDATE("follow");
        
        if (record.getCustomerId() != null) {
            SET("customer_id = #{customerId,jdbcType=BIGINT}");
        }
        
        if (record.getFollowUserId() != null) {
            SET("follow_user_id = #{followUserId,jdbcType=BIGINT}");
        }
        
        if (record.getFollowType() != null) {
            SET("follow_type = #{followType,jdbcType=INTEGER}");
        }
        
        if (record.getFollowContent() != null) {
            SET("follow_content = #{followContent,jdbcType=VARCHAR}");
        }
        
        if (record.getFollowTime() != null) {
            SET("follow_time = #{followTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("follow_id = #{followId,jdbcType=BIGINT}");
        
        return SQL();
    }
}