package salesapp.roommybatis.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import salesapp.roommybatis.entity.PBuilding;

public interface PBuildingMapper {
    @Delete({
        "delete from p_Building",
        "where BldGUID = #{bldguid,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String bldguid);

    @Insert({
        "insert into p_Building (BldGUID, BUGUID, ",
        "ProjGUID, BldCode, ",
        "BldName, ParentCode, ",
        "BldFullName, XPos, ",
        "YPos, DispMode, ",
        "PlanUrl, BldProPerty, ",
        "UnitNum, FloorNum, ",
        "IsBld, SaleRentable, ",
        "PlanBldArea, FactBldArea, ",
        "ScheduleMode, AreaFullName, ",
        "ProductGUID, Cq_IsDt, ",
        "ResourcesTypeGUID, ERPCode, ",
        "DefaultDiscount, YjjfDate, ",
        "TowerType, Area, ",
        "FloorList)",
        "values (#{bldguid,jdbcType=CHAR}, #{buguid,jdbcType=CHAR}, ",
        "#{projguid,jdbcType=CHAR}, #{bldcode,jdbcType=VARCHAR}, ",
        "#{bldname,jdbcType=VARCHAR}, #{parentcode,jdbcType=VARCHAR}, ",
        "#{bldfullname,jdbcType=VARCHAR}, #{xpos,jdbcType=INTEGER}, ",
        "#{ypos,jdbcType=INTEGER}, #{dispmode,jdbcType=VARCHAR}, ",
        "#{planurl,jdbcType=VARCHAR}, #{bldproperty,jdbcType=VARCHAR}, ",
        "#{unitnum,jdbcType=INTEGER}, #{floornum,jdbcType=INTEGER}, ",
        "#{isbld,jdbcType=TINYINT}, #{salerentable,jdbcType=VARCHAR}, ",
        "#{planbldarea,jdbcType=DECIMAL}, #{factbldarea,jdbcType=DECIMAL}, ",
        "#{schedulemode,jdbcType=VARCHAR}, #{areafullname,jdbcType=VARCHAR}, ",
        "#{productguid,jdbcType=CHAR}, #{cqIsdt,jdbcType=TINYINT}, ",
        "#{resourcestypeguid,jdbcType=CHAR}, #{erpcode,jdbcType=VARCHAR}, ",
        "#{defaultdiscount,jdbcType=DECIMAL}, #{yjjfdate,jdbcType=TIMESTAMP}, ",
        "#{towertype,jdbcType=VARCHAR}, #{area,jdbcType=VARCHAR}, ",
        "#{floorlist,jdbcType=LONGVARCHAR})"
    })
    int insert(PBuilding record);

    @InsertProvider(type=PBuildingSqlProvider.class, method="insertSelective")
    int insertSelective(PBuilding record);

    @Select({
        "select",
        "BldGUID, BUGUID, ProjGUID, BldCode, BldName, ParentCode, BldFullName, XPos, ",
        "YPos, DispMode, PlanUrl, BldProPerty, UnitNum, FloorNum, IsBld, SaleRentable, ",
        "PlanBldArea, FactBldArea, ScheduleMode, AreaFullName, ProductGUID, Cq_IsDt, ",
        "ResourcesTypeGUID, ERPCode, DefaultDiscount, YjjfDate, TowerType, Area, FloorList",
        "from p_Building",
        "where BldGUID = #{bldguid,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="BldGUID", property="bldguid", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="BUGUID", property="buguid", jdbcType=JdbcType.CHAR),
        @Result(column="ProjGUID", property="projguid", jdbcType=JdbcType.CHAR),
        @Result(column="BldCode", property="bldcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="BldName", property="bldname", jdbcType=JdbcType.VARCHAR),
        @Result(column="ParentCode", property="parentcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="BldFullName", property="bldfullname", jdbcType=JdbcType.VARCHAR),
        @Result(column="XPos", property="xpos", jdbcType=JdbcType.INTEGER),
        @Result(column="YPos", property="ypos", jdbcType=JdbcType.INTEGER),
        @Result(column="DispMode", property="dispmode", jdbcType=JdbcType.VARCHAR),
        @Result(column="PlanUrl", property="planurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="BldProPerty", property="bldproperty", jdbcType=JdbcType.VARCHAR),
        @Result(column="UnitNum", property="unitnum", jdbcType=JdbcType.INTEGER),
        @Result(column="FloorNum", property="floornum", jdbcType=JdbcType.INTEGER),
        @Result(column="IsBld", property="isbld", jdbcType=JdbcType.TINYINT),
        @Result(column="SaleRentable", property="salerentable", jdbcType=JdbcType.VARCHAR),
        @Result(column="PlanBldArea", property="planbldarea", jdbcType=JdbcType.DECIMAL),
        @Result(column="FactBldArea", property="factbldarea", jdbcType=JdbcType.DECIMAL),
        @Result(column="ScheduleMode", property="schedulemode", jdbcType=JdbcType.VARCHAR),
        @Result(column="AreaFullName", property="areafullname", jdbcType=JdbcType.VARCHAR),
        @Result(column="ProductGUID", property="productguid", jdbcType=JdbcType.CHAR),
        @Result(column="Cq_IsDt", property="cqIsdt", jdbcType=JdbcType.TINYINT),
        @Result(column="ResourcesTypeGUID", property="resourcestypeguid", jdbcType=JdbcType.CHAR),
        @Result(column="ERPCode", property="erpcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="DefaultDiscount", property="defaultdiscount", jdbcType=JdbcType.DECIMAL),
        @Result(column="YjjfDate", property="yjjfdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="TowerType", property="towertype", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.VARCHAR),
        @Result(column="FloorList", property="floorlist", jdbcType=JdbcType.LONGVARCHAR)
    })
    PBuilding selectByPrimaryKey(String bldguid);

    @UpdateProvider(type=PBuildingSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PBuilding record);

    @Update({
        "update p_Building",
        "set BUGUID = #{buguid,jdbcType=CHAR},",
          "ProjGUID = #{projguid,jdbcType=CHAR},",
          "BldCode = #{bldcode,jdbcType=VARCHAR},",
          "BldName = #{bldname,jdbcType=VARCHAR},",
          "ParentCode = #{parentcode,jdbcType=VARCHAR},",
          "BldFullName = #{bldfullname,jdbcType=VARCHAR},",
          "XPos = #{xpos,jdbcType=INTEGER},",
          "YPos = #{ypos,jdbcType=INTEGER},",
          "DispMode = #{dispmode,jdbcType=VARCHAR},",
          "PlanUrl = #{planurl,jdbcType=VARCHAR},",
          "BldProPerty = #{bldproperty,jdbcType=VARCHAR},",
          "UnitNum = #{unitnum,jdbcType=INTEGER},",
          "FloorNum = #{floornum,jdbcType=INTEGER},",
          "IsBld = #{isbld,jdbcType=TINYINT},",
          "SaleRentable = #{salerentable,jdbcType=VARCHAR},",
          "PlanBldArea = #{planbldarea,jdbcType=DECIMAL},",
          "FactBldArea = #{factbldarea,jdbcType=DECIMAL},",
          "ScheduleMode = #{schedulemode,jdbcType=VARCHAR},",
          "AreaFullName = #{areafullname,jdbcType=VARCHAR},",
          "ProductGUID = #{productguid,jdbcType=CHAR},",
          "Cq_IsDt = #{cqIsdt,jdbcType=TINYINT},",
          "ResourcesTypeGUID = #{resourcestypeguid,jdbcType=CHAR},",
          "ERPCode = #{erpcode,jdbcType=VARCHAR},",
          "DefaultDiscount = #{defaultdiscount,jdbcType=DECIMAL},",
          "YjjfDate = #{yjjfdate,jdbcType=TIMESTAMP},",
          "TowerType = #{towertype,jdbcType=VARCHAR},",
          "Area = #{area,jdbcType=VARCHAR},",
          "FloorList = #{floorlist,jdbcType=LONGVARCHAR}",
        "where BldGUID = #{bldguid,jdbcType=CHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(PBuilding record);

    @Update({
        "update p_Building",
        "set BUGUID = #{buguid,jdbcType=CHAR},",
          "ProjGUID = #{projguid,jdbcType=CHAR},",
          "BldCode = #{bldcode,jdbcType=VARCHAR},",
          "BldName = #{bldname,jdbcType=VARCHAR},",
          "ParentCode = #{parentcode,jdbcType=VARCHAR},",
          "BldFullName = #{bldfullname,jdbcType=VARCHAR},",
          "XPos = #{xpos,jdbcType=INTEGER},",
          "YPos = #{ypos,jdbcType=INTEGER},",
          "DispMode = #{dispmode,jdbcType=VARCHAR},",
          "PlanUrl = #{planurl,jdbcType=VARCHAR},",
          "BldProPerty = #{bldproperty,jdbcType=VARCHAR},",
          "UnitNum = #{unitnum,jdbcType=INTEGER},",
          "FloorNum = #{floornum,jdbcType=INTEGER},",
          "IsBld = #{isbld,jdbcType=TINYINT},",
          "SaleRentable = #{salerentable,jdbcType=VARCHAR},",
          "PlanBldArea = #{planbldarea,jdbcType=DECIMAL},",
          "FactBldArea = #{factbldarea,jdbcType=DECIMAL},",
          "ScheduleMode = #{schedulemode,jdbcType=VARCHAR},",
          "AreaFullName = #{areafullname,jdbcType=VARCHAR},",
          "ProductGUID = #{productguid,jdbcType=CHAR},",
          "Cq_IsDt = #{cqIsdt,jdbcType=TINYINT},",
          "ResourcesTypeGUID = #{resourcestypeguid,jdbcType=CHAR},",
          "ERPCode = #{erpcode,jdbcType=VARCHAR},",
          "DefaultDiscount = #{defaultdiscount,jdbcType=DECIMAL},",
          "YjjfDate = #{yjjfdate,jdbcType=TIMESTAMP},",
          "TowerType = #{towertype,jdbcType=VARCHAR},",
          "Area = #{area,jdbcType=VARCHAR}",
        "where BldGUID = #{bldguid,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(PBuilding record);
}