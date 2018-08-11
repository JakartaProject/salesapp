package salesapp.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import salesapp.mybatis.entity.Customer;

public interface CustomerMapperEx extends CustomerMapper {
	
    @Select({
    	"<script>",
        "select",
        "customer_id, customer_name, customer_mobile, customer_socialid, customer_gender, ",
        "customer_email, customer_address, status, associated_type, associated_user_id, ",
        "first_user_id, first_recv_time, last_comment_time",
        "from customer",
        "where associated_user_id in",
        "<foreach item='item' index='index' collection='sellerUserIds'",
        "open='(' separator=',' close=')'>",
        "#{item}",
        "</foreach>",
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
        @Result(column="last_comment_time", property="lastCommentTime", jdbcType=JdbcType.TIMESTAMP)
    })
	public List<Customer> selectCustomerByUser(@Param("sellerUserIds")List<String> sellerUserIds); 
}