package salesapp.mybatis.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import salesapp.mybatis.entity.User;

public interface UserMapper {
    @Delete({
        "delete from user",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userId);

    @Insert({
        "insert into user (user_id, user_name, ",
        "user_mobile, user_account, ",
        "user_pwd, user_role, ",
        "user_up, user_status, ",
        "user_remark, mysoft_user_code, ",
        "ct)",
        "values (#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{userMobile,jdbcType=VARCHAR}, #{userAccount,jdbcType=VARCHAR}, ",
        "#{userPwd,jdbcType=VARCHAR}, #{userRole,jdbcType=INTEGER}, ",
        "#{userUp,jdbcType=VARCHAR}, #{userStatus,jdbcType=INTEGER}, ",
        "#{userRemark,jdbcType=VARCHAR}, #{mysoftUserCode,jdbcType=VARCHAR}, ",
        "#{ct,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @Select({
        "select",
        "user_id, user_name, user_mobile, user_account, user_pwd, user_role, user_up, ",
        "user_status, user_remark, mysoft_user_code, ct",
        "from user",
        "where user_id = #{userId,jdbcType=VARCHAR}"
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
    User selectByPrimaryKey(String userId);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "user_mobile = #{userMobile,jdbcType=VARCHAR},",
          "user_account = #{userAccount,jdbcType=VARCHAR},",
          "user_pwd = #{userPwd,jdbcType=VARCHAR},",
          "user_role = #{userRole,jdbcType=INTEGER},",
          "user_up = #{userUp,jdbcType=VARCHAR},",
          "user_status = #{userStatus,jdbcType=INTEGER},",
          "user_remark = #{userRemark,jdbcType=VARCHAR},",
          "mysoft_user_code = #{mysoftUserCode,jdbcType=VARCHAR},",
          "ct = #{ct,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}