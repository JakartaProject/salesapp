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
import salesapp.mybatis.entity.Customer;

public interface CustomerMapper {
    @Delete({
        "delete from customer",
        "where customer_id = #{customerId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String customerId);

    @Insert({
        "insert into customer (customer_id, customer_name, ",
        "customer_mobile, customer_socialid, ",
        "customer_gender, customer_email, ",
        "customer_address, status, ",
        "associated_type, associated_user_id, ",
        "first_user_id, first_recv_time, ",
        "last_comment_time)",
        "values (#{customerId,jdbcType=VARCHAR}, #{customerName,jdbcType=VARCHAR}, ",
        "#{customerMobile,jdbcType=VARCHAR}, #{customerSocialid,jdbcType=VARCHAR}, ",
        "#{customerGender,jdbcType=INTEGER}, #{customerEmail,jdbcType=VARCHAR}, ",
        "#{customerAddress,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{associatedType,jdbcType=INTEGER}, #{associatedUserId,jdbcType=VARCHAR}, ",
        "#{firstUserId,jdbcType=VARCHAR}, #{firstRecvTime,jdbcType=TIMESTAMP}, ",
        "#{lastCommentTime,jdbcType=TIMESTAMP})"
    })
    int insert(Customer record);

    @InsertProvider(type=CustomerSqlProvider.class, method="insertSelective")
    int insertSelective(Customer record);

    @Select({
        "select",
        "customer_id, customer_name, customer_mobile, customer_socialid, customer_gender, ",
        "customer_email, customer_address, status, associated_type, associated_user_id, ",
        "first_user_id, first_recv_time, last_comment_time",
        "from customer",
        "where customer_id = #{customerId,jdbcType=VARCHAR}"
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
    Customer selectByPrimaryKey(String customerId);

    @UpdateProvider(type=CustomerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Customer record);

    @Update({
        "update customer",
        "set customer_name = #{customerName,jdbcType=VARCHAR},",
          "customer_mobile = #{customerMobile,jdbcType=VARCHAR},",
          "customer_socialid = #{customerSocialid,jdbcType=VARCHAR},",
          "customer_gender = #{customerGender,jdbcType=INTEGER},",
          "customer_email = #{customerEmail,jdbcType=VARCHAR},",
          "customer_address = #{customerAddress,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "associated_type = #{associatedType,jdbcType=INTEGER},",
          "associated_user_id = #{associatedUserId,jdbcType=VARCHAR},",
          "first_user_id = #{firstUserId,jdbcType=VARCHAR},",
          "first_recv_time = #{firstRecvTime,jdbcType=TIMESTAMP},",
          "last_comment_time = #{lastCommentTime,jdbcType=TIMESTAMP}",
        "where customer_id = #{customerId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Customer record);
}