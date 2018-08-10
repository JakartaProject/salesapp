package salesapp.roommybatis.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import salesapp.roommybatis.entity.PBuilding;

public class PBuildingSqlProvider {

    public String insertSelective(PBuilding record) {
        BEGIN();
        INSERT_INTO("p_Building");
        
        if (record.getBldguid() != null) {
            VALUES("BldGUID", "#{bldguid,jdbcType=CHAR}");
        }
        
        if (record.getBuguid() != null) {
            VALUES("BUGUID", "#{buguid,jdbcType=CHAR}");
        }
        
        if (record.getProjguid() != null) {
            VALUES("ProjGUID", "#{projguid,jdbcType=CHAR}");
        }
        
        if (record.getBldcode() != null) {
            VALUES("BldCode", "#{bldcode,jdbcType=VARCHAR}");
        }
        
        if (record.getBldname() != null) {
            VALUES("BldName", "#{bldname,jdbcType=VARCHAR}");
        }
        
        if (record.getParentcode() != null) {
            VALUES("ParentCode", "#{parentcode,jdbcType=VARCHAR}");
        }
        
        if (record.getBldfullname() != null) {
            VALUES("BldFullName", "#{bldfullname,jdbcType=VARCHAR}");
        }
        
        if (record.getXpos() != null) {
            VALUES("XPos", "#{xpos,jdbcType=INTEGER}");
        }
        
        if (record.getYpos() != null) {
            VALUES("YPos", "#{ypos,jdbcType=INTEGER}");
        }
        
        if (record.getDispmode() != null) {
            VALUES("DispMode", "#{dispmode,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanurl() != null) {
            VALUES("PlanUrl", "#{planurl,jdbcType=VARCHAR}");
        }
        
        if (record.getBldproperty() != null) {
            VALUES("BldProPerty", "#{bldproperty,jdbcType=VARCHAR}");
        }
        
        if (record.getUnitnum() != null) {
            VALUES("UnitNum", "#{unitnum,jdbcType=INTEGER}");
        }
        
        if (record.getFloornum() != null) {
            VALUES("FloorNum", "#{floornum,jdbcType=INTEGER}");
        }
        
        if (record.getIsbld() != null) {
            VALUES("IsBld", "#{isbld,jdbcType=TINYINT}");
        }
        
        if (record.getSalerentable() != null) {
            VALUES("SaleRentable", "#{salerentable,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanbldarea() != null) {
            VALUES("PlanBldArea", "#{planbldarea,jdbcType=DECIMAL}");
        }
        
        if (record.getFactbldarea() != null) {
            VALUES("FactBldArea", "#{factbldarea,jdbcType=DECIMAL}");
        }
        
        if (record.getSchedulemode() != null) {
            VALUES("ScheduleMode", "#{schedulemode,jdbcType=VARCHAR}");
        }
        
        if (record.getAreafullname() != null) {
            VALUES("AreaFullName", "#{areafullname,jdbcType=VARCHAR}");
        }
        
        if (record.getProductguid() != null) {
            VALUES("ProductGUID", "#{productguid,jdbcType=CHAR}");
        }
        
        if (record.getCqIsdt() != null) {
            VALUES("Cq_IsDt", "#{cqIsdt,jdbcType=TINYINT}");
        }
        
        if (record.getResourcestypeguid() != null) {
            VALUES("ResourcesTypeGUID", "#{resourcestypeguid,jdbcType=CHAR}");
        }
        
        if (record.getErpcode() != null) {
            VALUES("ERPCode", "#{erpcode,jdbcType=VARCHAR}");
        }
        
        if (record.getDefaultdiscount() != null) {
            VALUES("DefaultDiscount", "#{defaultdiscount,jdbcType=DECIMAL}");
        }
        
        if (record.getYjjfdate() != null) {
            VALUES("YjjfDate", "#{yjjfdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTowertype() != null) {
            VALUES("TowerType", "#{towertype,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            VALUES("Area", "#{area,jdbcType=VARCHAR}");
        }
        
        if (record.getFloorlist() != null) {
            VALUES("FloorList", "#{floorlist,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(PBuilding record) {
        BEGIN();
        UPDATE("p_Building");
        
        if (record.getBuguid() != null) {
            SET("BUGUID = #{buguid,jdbcType=CHAR}");
        }
        
        if (record.getProjguid() != null) {
            SET("ProjGUID = #{projguid,jdbcType=CHAR}");
        }
        
        if (record.getBldcode() != null) {
            SET("BldCode = #{bldcode,jdbcType=VARCHAR}");
        }
        
        if (record.getBldname() != null) {
            SET("BldName = #{bldname,jdbcType=VARCHAR}");
        }
        
        if (record.getParentcode() != null) {
            SET("ParentCode = #{parentcode,jdbcType=VARCHAR}");
        }
        
        if (record.getBldfullname() != null) {
            SET("BldFullName = #{bldfullname,jdbcType=VARCHAR}");
        }
        
        if (record.getXpos() != null) {
            SET("XPos = #{xpos,jdbcType=INTEGER}");
        }
        
        if (record.getYpos() != null) {
            SET("YPos = #{ypos,jdbcType=INTEGER}");
        }
        
        if (record.getDispmode() != null) {
            SET("DispMode = #{dispmode,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanurl() != null) {
            SET("PlanUrl = #{planurl,jdbcType=VARCHAR}");
        }
        
        if (record.getBldproperty() != null) {
            SET("BldProPerty = #{bldproperty,jdbcType=VARCHAR}");
        }
        
        if (record.getUnitnum() != null) {
            SET("UnitNum = #{unitnum,jdbcType=INTEGER}");
        }
        
        if (record.getFloornum() != null) {
            SET("FloorNum = #{floornum,jdbcType=INTEGER}");
        }
        
        if (record.getIsbld() != null) {
            SET("IsBld = #{isbld,jdbcType=TINYINT}");
        }
        
        if (record.getSalerentable() != null) {
            SET("SaleRentable = #{salerentable,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanbldarea() != null) {
            SET("PlanBldArea = #{planbldarea,jdbcType=DECIMAL}");
        }
        
        if (record.getFactbldarea() != null) {
            SET("FactBldArea = #{factbldarea,jdbcType=DECIMAL}");
        }
        
        if (record.getSchedulemode() != null) {
            SET("ScheduleMode = #{schedulemode,jdbcType=VARCHAR}");
        }
        
        if (record.getAreafullname() != null) {
            SET("AreaFullName = #{areafullname,jdbcType=VARCHAR}");
        }
        
        if (record.getProductguid() != null) {
            SET("ProductGUID = #{productguid,jdbcType=CHAR}");
        }
        
        if (record.getCqIsdt() != null) {
            SET("Cq_IsDt = #{cqIsdt,jdbcType=TINYINT}");
        }
        
        if (record.getResourcestypeguid() != null) {
            SET("ResourcesTypeGUID = #{resourcestypeguid,jdbcType=CHAR}");
        }
        
        if (record.getErpcode() != null) {
            SET("ERPCode = #{erpcode,jdbcType=VARCHAR}");
        }
        
        if (record.getDefaultdiscount() != null) {
            SET("DefaultDiscount = #{defaultdiscount,jdbcType=DECIMAL}");
        }
        
        if (record.getYjjfdate() != null) {
            SET("YjjfDate = #{yjjfdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTowertype() != null) {
            SET("TowerType = #{towertype,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            SET("Area = #{area,jdbcType=VARCHAR}");
        }
        
        if (record.getFloorlist() != null) {
            SET("FloorList = #{floorlist,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("BldGUID = #{bldguid,jdbcType=CHAR}");
        
        return SQL();
    }
}