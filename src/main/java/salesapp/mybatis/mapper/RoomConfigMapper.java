package salesapp.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import salesapp.mybatis.entity.RoomConfig;

public interface RoomConfigMapper {
    @Insert({
        "insert into room_config (tower_type, room_type, ",
        "picture, area, price, ",
        "total, ct)",
        "values (#{towerType,jdbcType=VARCHAR}, #{roomType,jdbcType=VARCHAR}, ",
        "#{picture,jdbcType=VARCHAR}, #{area,jdbcType=DECIMAL}, #{price,jdbcType=DECIMAL}, ",
        "#{total,jdbcType=DECIMAL}, #{ct,jdbcType=TIMESTAMP})"
    })
    int insert(RoomConfig record);

    @InsertProvider(type=RoomConfigSqlProvider.class, method="insertSelective")
    int insertSelective(RoomConfig record);
}