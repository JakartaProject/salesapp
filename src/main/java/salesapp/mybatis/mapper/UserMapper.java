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
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    @Insert({
        "insert into user (user_id, user_name, ",
        "user_mobile, user_account, ",
        "user_pwd, user_role, ",
        "user_up, user_status, ",
        "mysoft_user_code, ct)",
        "values (#{userId,jdbcType=BIGINT}, #{userName,jdbcType=VARCHAR}, ",
        "#{userMobile,jdbcType=VARCHAR}, #{userAccount,jdbcType=VARCHAR}, ",
        "#{userPwd,jdbcType=VARCHAR}, #{userRole,jdbcType=INTEGER}, ",
        "#{userUp,jdbcType=BIGINT}, #{userStatus,jdbcType=INTEGER}, ",
        "#{mysoftUserCode,jdbcType=VARCHAR}, #{ct,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @Select({
        "select",
        "user_id, user_name, user_mobile, user_account, user_pwd, user_role, user_up, ",
        "user_status, mysoft_user_code, ct",
        "from user",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_mobile", property="userMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_account", property="userAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_pwd", property="userPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_role", property="userRole", jdbcType=JdbcType.INTEGER),
        @Result(column="user_up", property="userUp", jdbcType=JdbcType.BIGINT),
        @Result(column="user_status", property="userStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="mysoft_user_code", property="mysoftUserCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ct", property="ct", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(Long userId);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "user_mobile = #{userMobile,jdbcType=VARCHAR},",
          "user_account = #{userAccount,jdbcType=VARCHAR},",
          "user_pwd = #{userPwd,jdbcType=VARCHAR},",
          "user_role = #{userRole,jdbcType=INTEGER},",
          "user_up = #{userUp,jdbcType=BIGINT},",
          "user_status = #{userStatus,jdbcType=INTEGER},",
          "mysoft_user_code = #{mysoftUserCode,jdbcType=VARCHAR},",
          "ct = #{ct,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}