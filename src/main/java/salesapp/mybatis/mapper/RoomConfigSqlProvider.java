package salesapp.mybatis.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import salesapp.mybatis.entity.RoomConfig;

public class RoomConfigSqlProvider {

    public String insertSelective(RoomConfig record) {
        BEGIN();
        INSERT_INTO("room_config");
        
        if (record.getTowerType() != null) {
            VALUES("tower_type", "#{towerType,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomType() != null) {
            VALUES("room_type", "#{roomType,jdbcType=VARCHAR}");
        }
        
        if (record.getPicture() != null) {
            VALUES("picture", "#{picture,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            VALUES("area", "#{area,jdbcType=DECIMAL}");
        }
        
        if (record.getPrice() != null) {
            VALUES("price", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getTotal() != null) {
            VALUES("total", "#{total,jdbcType=DECIMAL}");
        }
        
        if (record.getCt() != null) {
            VALUES("ct", "#{ct,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }
}