package salesapp.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import salesapp.mybatis.entity.RoomConfig;
import salesapp.mybatis.mapper.RoomConfigMapperEx;
import salesapp.roommybatis.entity.PRoom;
import salesapp.roommybatis.mapper.PRoomMapperEx;

@Service
public class RoomService {
	@Resource
	private PRoomMapperEx pRoomMapperEx;
	
	@Resource
	private RoomConfigMapperEx roomConfigMapperEx;

	public List<SimpleRoom> searchRooms(String structure, String areaFrom, String areaTo, String priceFrom,
			String priceTo, String totalPriceFrom, String totalPriceTo) {
		return simple(pRoomMapperEx.search(formatNull(structure), formatNull(areaFrom), formatNull(areaTo),
				formatNull(priceFrom), formatNull(priceTo), formatNull(totalPriceFrom), formatNull(totalPriceTo)));
	}

	public SimpleRoom checkRoom(String roomGUID) {
		return simple(pRoomMapperEx.selectByPrimaryKey(roomGUID));
	}

	private SimpleRoom simple(PRoom room) {
		SimpleRoom simple = new SimpleRoom();
		simple.setArea(room.getBldarea());
		simple.setPrice(room.getPricedj());
		simple.setTotalPrice(room.getTotaldj());
		simple.setStructure(room.getRoomstru());
		// 59009-UU-35-3516
		// block-tower-floor-room
		simple.setRoomShortInfo(room.getRoomshortinfo());
		String[] roomInfo = room.getRoomshortinfo().split("-");
		simple.setBlockNo(roomInfo[0]);
		simple.setTowerNo(roomInfo[1]);
		simple.setFloor(roomInfo[2]);
		simple.setRoomNo(roomInfo[3].replaceFirst(roomInfo[2], ""));
		simple.setTowerStructure(getTowerStructure(simple.getTowerNo()));
		simple.setRoomType(room.getHuxing());
		simple.setPic(findPic(simple.getTowerStructure(), simple.getRoomType()));
		return simple;
	}

	private String findPic(String towerStructure, String roomType) {
		RoomConfig config = roomConfigMapperEx.selectByTowerAndRoom(towerStructure, roomType);
		if (config == null) {
			return null;
		}
		return config.getPicture();
	}

	private List<SimpleRoom> simple(List<PRoom> room) {
		List<SimpleRoom> ret = new LinkedList<SimpleRoom>();
		room.forEach(r -> ret.add(simple(r)));
		return ret;
	}
	
	private String getTowerStructure(String towerNo) {
		if (towerNo.contains("a") || towerNo.contains("A")) {
			return "A";
		}
		if (towerNo.contains("b") || towerNo.contains("B")) {
			return "B";
		}
		if (towerNo.contains("c") || towerNo.contains("C")) {
			return "C";
		}
		if (towerNo.contains("d") || towerNo.contains("D")) {
			return "D";
		}
		if (towerNo.contains("e") || towerNo.contains("E")) {
			return "E";
		}
		if (towerNo.contains("s") || towerNo.contains("S")) {
			return "S";
		}
		if (towerNo.contains("t") || towerNo.contains("T")) {
			return "T";
		}
		if (towerNo.contains("u") || towerNo.contains("U")) {
			return "U";
		}
		return towerNo;
	}

	public static class SimpleRoom {
		private BigDecimal area;
		private BigDecimal price;
		private BigDecimal totalPrice;
		private String structure;
		
		private String roomShortInfo;
		private String blockNo;
		private String towerNo;
		private String floor;
		private String roomNo;
		
		private String towerStructure;
		private String roomType;
		private String pic;
		public BigDecimal getArea() {
			return area;
		}
		public void setArea(BigDecimal area) {
			this.area = area;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public BigDecimal getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(BigDecimal totalPrice) {
			this.totalPrice = totalPrice;
		}
		public String getStructure() {
			return structure;
		}
		public void setStructure(String structure) {
			this.structure = structure;
		}
		public String getRoomShortInfo() {
			return roomShortInfo;
		}
		public void setRoomShortInfo(String roomShortInfo) {
			this.roomShortInfo = roomShortInfo;
		}
		public String getTowerStructure() {
			return towerStructure;
		}
		public void setTowerStructure(String towerStructure) {
			this.towerStructure = towerStructure;
		}
		public String getRoomType() {
			return roomType;
		}
		public void setRoomType(String roomType) {
			this.roomType = roomType;
		}
		public String getPic() {
			return pic;
		}
		public void setPic(String pic) {
			this.pic = pic;
		}
		public String getBlockNo() {
			return blockNo;
		}
		public void setBlockNo(String blockNo) {
			this.blockNo = blockNo;
		}
		public String getTowerNo() {
			return towerNo;
		}
		public void setTowerNo(String towerNo) {
			this.towerNo = towerNo;
		}
		public String getFloor() {
			return floor;
		}
		public void setFloor(String floor) {
			this.floor = floor;
		}
		public String getRoomNo() {
			return roomNo;
		}
		public void setRoomNo(String roomNo) {
			this.roomNo = roomNo;
		}
	}

	private String formatNull(String source) {
		if (source == null || source.trim().isEmpty()) {
			return null;
		}
		return source.trim();
	}
}
