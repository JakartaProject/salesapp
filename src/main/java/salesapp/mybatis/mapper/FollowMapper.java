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
import salesapp.mybatis.entity.Follow;

public interface FollowMapper {
    @Delete({
        "delete from follow",
        "where follow_id = #{followId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String followId);

    @Insert({
        "insert into follow (follow_id, customer_id, ",
        "follow_user_id, follow_type, ",
        "follow_content, follow_time)",
        "values (#{followId,jdbcType=VARCHAR}, #{customerId,jdbcType=VARCHAR}, ",
        "#{followUserId,jdbcType=VARCHAR}, #{followType,jdbcType=INTEGER}, ",
        "#{followContent,jdbcType=VARCHAR}, #{followTime,jdbcType=TIMESTAMP})"
    })
    int insert(Follow record);

    @InsertProvider(type=FollowSqlProvider.class, method="insertSelective")
    int insertSelective(Follow record);

    @Select({
        "select",
        "follow_id, customer_id, follow_user_id, follow_type, follow_content, follow_time",
        "from follow",
        "where follow_id = #{followId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="follow_id", property="followId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.VARCHAR),
        @Result(column="follow_user_id", property="followUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="follow_type", property="followType", jdbcType=JdbcType.INTEGER),
        @Result(column="follow_content", property="followContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="follow_time", property="followTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Follow selectByPrimaryKey(String followId);

    @UpdateProvider(type=FollowSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Follow record);

    @Update({
        "update follow",
        "set customer_id = #{customerId,jdbcType=VARCHAR},",
          "follow_user_id = #{followUserId,jdbcType=VARCHAR},",
          "follow_type = #{followType,jdbcType=INTEGER},",
          "follow_content = #{followContent,jdbcType=VARCHAR},",
          "follow_time = #{followTime,jdbcType=TIMESTAMP}",
        "where follow_id = #{followId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Follow record);
}