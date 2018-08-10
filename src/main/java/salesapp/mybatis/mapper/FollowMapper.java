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
        "where follow_id = #{followId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long followId);

    @Insert({
        "insert into follow (follow_id, customer_id, ",
        "follow_user_id, follow_type, ",
        "follow_content, follow_time)",
        "values (#{followId,jdbcType=BIGINT}, #{customerId,jdbcType=BIGINT}, ",
        "#{followUserId,jdbcType=BIGINT}, #{followType,jdbcType=INTEGER}, ",
        "#{followContent,jdbcType=VARCHAR}, #{followTime,jdbcType=TIMESTAMP})"
    })
    int insert(Follow record);

    @InsertProvider(type=FollowSqlProvider.class, method="insertSelective")
    int insertSelective(Follow record);

    @Select({
        "select",
        "follow_id, customer_id, follow_user_id, follow_type, follow_content, follow_time",
        "from follow",
        "where follow_id = #{followId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="follow_id", property="followId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.BIGINT),
        @Result(column="follow_user_id", property="followUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="follow_type", property="followType", jdbcType=JdbcType.INTEGER),
        @Result(column="follow_content", property="followContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="follow_time", property="followTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Follow selectByPrimaryKey(Long followId);

    @UpdateProvider(type=FollowSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Follow record);

    @Update({
        "update follow",
        "set customer_id = #{customerId,jdbcType=BIGINT},",
          "follow_user_id = #{followUserId,jdbcType=BIGINT},",
          "follow_type = #{followType,jdbcType=INTEGER},",
          "follow_content = #{followContent,jdbcType=VARCHAR},",
          "follow_time = #{followTime,jdbcType=TIMESTAMP}",
        "where follow_id = #{followId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Follow record);
}