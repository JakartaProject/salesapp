package salesapp.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import salesapp.service.MktResp;
import salesapp.service.RoomService;
import salesapp.service.RoomService.SimpleRoom;

@RestController
@RequestMapping("rest/room")
public class RoomController {
	@Resource
	private RoomService roomService;

	@RequestMapping(path = "searchRooms", method = RequestMethod.GET)
	public MktResp<List<SimpleRoom>> searchRooms(@RequestParam(ApiC.s) String session,
			@RequestParam(value = "structure", required = false) String structure,
			@RequestParam(value = "areaFrom", required = false) String areaFrom,
			@RequestParam(value = "areaTo", required = false) String areaTo,
			@RequestParam(value = "priceFrom", required = false) String priceFrom,
			@RequestParam(value = "priceTo", required = false) String priceTo,
			@RequestParam(value = "totalPriceFrom", required = false) String totalPriceFrom,
			@RequestParam(value = "totalPriceTo", required = false) String totalPriceTo) {
		return new MktResp<List<SimpleRoom>>(
				roomService.searchRooms(structure, areaFrom, areaTo, priceFrom, priceTo, totalPriceFrom, totalPriceTo));
	}

	@RequestMapping(path = "checkRoom", method = RequestMethod.GET)
	public MktResp<SimpleRoom> checkRoom(@RequestParam("roomGUID") String roomGUID) {
		return new MktResp<SimpleRoom>(roomService.checkRoom(roomGUID));
	}
}
