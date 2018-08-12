package salesapp.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import salesapp.mybatis.entity.FollowEx;

public interface FollowMapperEx extends FollowMapper {
	  @Select({
	        "select",
	        "f.follow_id, f.customer_id, f.follow_user_id, f.follow_type, f.follow_content, f.follow_time,",
	        "u.user_role, u.user_name",
	        "from follow f",
	        "left join user u",
	        "on f.follow_user_id = u.user_id",
	        "where f.customer_id = #{customerId,jdbcType=VARCHAR} order by f.follow_id desc"
	    })
	    @Results({
	        @Result(column="follow_id", property="followId", jdbcType=JdbcType.VARCHAR, id=true),
	        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.VARCHAR),
	        @Result(column="follow_user_id", property="followUserId", jdbcType=JdbcType.VARCHAR),
	        @Result(column="follow_type", property="followType", jdbcType=JdbcType.INTEGER),
	        @Result(column="follow_content", property="followContent", jdbcType=JdbcType.VARCHAR),
	        @Result(column="follow_time", property="followTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="user_role", property="associatedUserRole", jdbcType=JdbcType.INTEGER),
	        @Result(column="user_name", property="associatedUserName", jdbcType=JdbcType.VARCHAR)
	    })
	List<FollowEx> selectByCustomerId(String customerId);
}
