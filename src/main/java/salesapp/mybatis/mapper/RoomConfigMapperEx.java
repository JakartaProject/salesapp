package salesapp.mybatis.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import salesapp.mybatis.entity.RoomConfig;

public interface RoomConfigMapperEx extends RoomConfigMapper {
	@Select({ "select * from room_config where tower_type = #{towerType} and room_type = #{roomType}" })
	@Results({ @Result(column = "tower_type", property = "towerType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "room_type", property = "roomType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "picture", property = "picture", jdbcType = JdbcType.VARCHAR),
			@Result(column = "area", property = "area", jdbcType = JdbcType.BIGINT),
			@Result(column = "price", property = "price", jdbcType = JdbcType.BIGINT),
			@Result(column = "total", property = "total", jdbcType = JdbcType.BIGINT),
			@Result(column = "ct", property = "ct", jdbcType = JdbcType.DATE) })
	public RoomConfig selectByTowerAndRoom(String towerType, String roomType);
}
