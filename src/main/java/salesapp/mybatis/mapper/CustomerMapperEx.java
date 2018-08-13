package salesapp.mybatis.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import salesapp.mybatis.entity.Customer;
import salesapp.mybatis.entity.CustomerEx;

public interface CustomerMapperEx extends CustomerMapper {
	
    @Select({
    	"<script>",
        "select",
        "customer_id, customer_name, customer_mobile, customer_socialid, customer_gender, ",
        "customer_email, customer_address, status, associated_type, associated_user_id, ",
        "first_user_id, first_recv_time, last_follow_time, last_follow_id",
        "from customer",
        "where associated_user_id in",
        "<foreach item='item' index='index' collection='userIds'",
        "open='(' separator=',' close=')'>",
        "#{item}",
        "</foreach>",
        "<if test='searchStr != null'>",
        "  and (customer_name like '%${searchStr}%' or customer_mobile like '%${searchStr}%' or customer_socialid like '%${searchStr}%')",
        "</if>",
        "order by last_follow_time desc",
    	"</script>",
    })
    @Results({
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_mobile", property="customerMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_socialid", property="customerSocialid", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_gender", property="customerGender", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_email", property="customerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_address", property="customerAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="associated_type", property="associatedType", jdbcType=JdbcType.INTEGER),
        @Result(column="associated_user_id", property="associatedUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="first_user_id", property="firstUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="first_recv_time", property="firstRecvTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_follow_time", property="lastFollowTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_follow_id", property="lastFollowId", jdbcType=JdbcType.VARCHAR)
    })
	public List<Customer> selectAssociatedCustomerByUser(@Param("userIds")List<String> userIds, @Param("searchStr") String searchStr); 
    
    @Select({
        "select",
        "customer_id, customer_name, customer_mobile, customer_socialid, customer_gender, ",
        "customer_email, customer_address, status, associated_type, associated_user_id, ",
        "first_user_id, first_recv_time, last_follow_time, last_follow_id",
        "from customer",
        "where customer_mobile = #{mobile,jdbcType=VARCHAR} and customer_socialid = #{socialId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_mobile", property="customerMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_socialid", property="customerSocialid", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_gender", property="customerGender", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_email", property="customerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_address", property="customerAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="associated_type", property="associatedType", jdbcType=JdbcType.INTEGER),
        @Result(column="associated_user_id", property="associatedUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="first_user_id", property="firstUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="first_recv_time", property="firstRecvTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_follow_time", property="lastFollowTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_follow_id", property="lastFollowId", jdbcType=JdbcType.VARCHAR)
    })
    Customer selectByMobileAndSocialId(@Param("mobile") String mobile, @Param("socialId") String socialId);

    @Select({
        "select",
        "customer_id, customer_name, customer_mobile, customer_socialid, customer_gender, ",
        "customer_email, customer_address, status, associated_type, associated_user_id, ",
        "first_user_id, first_recv_time, last_follow_time, last_follow_id",
        "from customer",
        "where customer_name like '%${str}%' or customer_mobile like '%${str}%' or customer_socialid like '%${str}%'"
    })
    @Results({
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_mobile", property="customerMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_socialid", property="customerSocialid", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_gender", property="customerGender", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_email", property="customerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_address", property="customerAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="associated_type", property="associatedType", jdbcType=JdbcType.INTEGER),
        @Result(column="associated_user_id", property="associatedUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="first_user_id", property="firstUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="first_recv_time", property="firstRecvTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_follow_time", property="lastFollowTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_follow_id", property="lastFollowId", jdbcType=JdbcType.VARCHAR)
    })
	public List<Customer> searchNameMobileSocialid(@Param("str") String str);

    @Select({
    	"<script>",
        "select",
        "c.customer_id, c.customer_name, c.customer_mobile, c.customer_socialid, c.customer_gender, ",
        "c.customer_email, c.customer_address, c.status, c.associated_type, c.associated_user_id, ",
        "c.first_user_id, c.first_recv_time, c.last_follow_time, c.last_follow_id,",
        "u.user_name, u.user_mobile, u.user_position",
        "from customer c",
        "left join user u",
        "on c.associated_user_id = u.user_id",
        "where c.associated_user_id in ",
        "<foreach item='item' index='index' collection='allids'",
        "open='(' separator=',' close=')'>",
        "#{item}",
        "</foreach>",
        "</script>"
    })
    @Results({
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_mobile", property="customerMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_socialid", property="customerSocialid", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_gender", property="customerGender", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_email", property="customerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_address", property="customerAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="associated_type", property="associatedType", jdbcType=JdbcType.INTEGER),
        @Result(column="associated_user_id", property="associatedUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="associatedUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_mobile", property="associatedUserMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_position", property="associatedUserPosition", jdbcType=JdbcType.VARCHAR),
        @Result(column="first_user_id", property="firstUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="first_recv_time", property="firstRecvTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_follow_time", property="lastFollowTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_follow_id", property="lastFollowId", jdbcType=JdbcType.VARCHAR)
    })
	public List<CustomerEx> selectMyCustomerOrderByFollowTime(@Param("allids")Set<String> allids);

    @Select({
        "select",
        "c.customer_id, c.customer_name, c.customer_mobile, c.customer_socialid, c.customer_gender, ",
        "c.customer_email, c.customer_address, c.status, c.associated_type, c.associated_user_id, ",
        "c.first_user_id, c.first_recv_time, c.last_follow_time, c.last_follow_id,",
        "u.user_name, u.user_mobile, u.user_position",
        "from customer c",
        "left join user u",
        "on c.associated_user_id = u.user_id",
        "where c.customer_id = #{customerId} ",
    })
    @Results({
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_mobile", property="customerMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_socialid", property="customerSocialid", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_gender", property="customerGender", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_email", property="customerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_address", property="customerAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="associated_type", property="associatedType", jdbcType=JdbcType.INTEGER),
        @Result(column="associated_user_id", property="associatedUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="associatedUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_mobile", property="associatedUserMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_position", property="associatedUserPosition", jdbcType=JdbcType.VARCHAR),
        @Result(column="first_user_id", property="firstUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="first_recv_time", property="firstRecvTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_follow_time", property="lastFollowTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_follow_id", property="lastFollowId", jdbcType=JdbcType.VARCHAR)
    })
	public CustomerEx selectExByPrimaryKey(String customerId);

    @Select({
    	"<script>",
        "select",
        "count(*)",
        "from customer",
        "where associated_user_id = #{operId} and customer_id in",
        "<foreach item='item' index='index' collection='customerIds'",
        "open='(' separator=',' close=')'>",
        "#{item}",
        "</foreach>",
        "</script>"
    })
	public int checkAssociated(@Param("customerIds") List<String> customerIds,@Param("operId") String operId);

    @Update({
    	"<script>",
        "update customer",
        "set status = #{status,jdbcType=INTEGER},",
          "associated_type = 2,",
          "associated_user_id = #{userId,jdbcType=VARCHAR},",
        "where customer_id in",
        "<foreach item='item' index='index' collection='customerIds'",
        "open='(' separator=',' close=')'>",
        "#{item}",
        "</foreach>",
        "</script>"
    })
	public int allocateAssociated(@Param("customerIds") List<String> customerIds, @Param("userId") String userId, @Param("status") int status);
}
