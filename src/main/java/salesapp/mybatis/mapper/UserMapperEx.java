package salesapp.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import salesapp.mybatis.entity.User;
import salesapp.mybatis.entity.UserEx;

public interface UserMapperEx extends UserMapper {
    @Select({
        "select",
        "user_id, user_name, user_mobile, user_account, user_pwd, user_role, user_up, ",
        "user_status, user_remark, mysoft_user_code, ct",
        "from user",
        "where user_account = #{account,jdbcType=VARCHAR} and user_status = 1"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_mobile", property="userMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_account", property="userAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_pwd", property="userPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_role", property="userRole", jdbcType=JdbcType.INTEGER),
        @Result(column="user_up", property="userUp", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_status", property="userStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="user_remark", property="userRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="mysoft_user_code", property="mysoftUserCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ct", property="ct", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectRegistedByAccount(String account);
    
    @Select({
        "select",
        "user_id, user_name, user_mobile, user_account, user_pwd, user_role, user_up, ",
        "user_status, user_remark, mysoft_user_code, ct",
        "from user",
        "where mysoft_user_code = #{mysoftUserCode,jdbcType=VARCHAR} and user_status = 1"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_mobile", property="userMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_account", property="userAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_pwd", property="userPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_role", property="userRole", jdbcType=JdbcType.INTEGER),
        @Result(column="user_up", property="userUp", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_status", property="userStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="user_remark", property="userRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="mysoft_user_code", property="mysoftUserCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ct", property="ct", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectRegistedByMysoftUserCode(String mysoftUserCode);
    
    @Select({
        "select",
        "user_id, user_name, user_mobile, user_account, user_pwd, user_role, user_up, ",
        "user_status, user_remark, mysoft_user_code, ct,",
        "(select count(*) from customer where associated_user_id in ((select user_id from user where user_up = a.user_id) union select(a.user_id))) as customer_num, ",
        "(select count(*) from user where user_up = a.user_id) as next_level_num ",
        "from user a",
        "where user_up = #{userId,jdbcType=VARCHAR} and user_status = 1"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_mobile", property="userMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_account", property="userAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_pwd", property="userPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_role", property="userRole", jdbcType=JdbcType.INTEGER),
        @Result(column="user_up", property="userUp", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_status", property="userStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="user_remark", property="userRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="mysoft_user_code", property="mysoftUserCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ct", property="ct", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="customer_num", property="customerNum", jdbcType=JdbcType.INTEGER),
        @Result(column="next_level_num", property="nextLevelNum", jdbcType=JdbcType.INTEGER)
    })
	List<UserEx> selectRegistedExByUp(String userId);
    
    @Select({
    	"<script>",
        "select",
        "user_id, user_name, user_mobile, user_account, user_pwd, user_role, user_up, ",
        "user_status, user_remark, mysoft_user_code, ct",
        "from user ",
        "where user_status = 1 and user_up in ",
        "<foreach item='item' index='index' collection='uplevel'",
        "open='(' separator=',' close=')'>",
        "#{item}",
        "</foreach>",
        "</script>"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_mobile", property="userMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_account", property="userAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_pwd", property="userPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_role", property="userRole", jdbcType=JdbcType.INTEGER),
        @Result(column="user_up", property="userUp", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_status", property="userStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="user_remark", property="userRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="mysoft_user_code", property="mysoftUserCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ct", property="ct", jdbcType=JdbcType.TIMESTAMP)
    })
	List<User> selectRegistedByUplevel(@Param("uplevel") List<String> uplevel);
}
