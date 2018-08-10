package salesapp.roommybatis.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import salesapp.roommybatis.entity.PRoom;

public class PRoomSqlProvider {

    public String insertSelective(PRoom record) {
        BEGIN();
        INSERT_INTO("p_Room");
        
        if (record.getRoomguid() != null) {
            VALUES("RoomGUID", "#{roomguid,jdbcType=CHAR}");
        }
        
        if (record.getBuguid() != null) {
            VALUES("BUGUID", "#{buguid,jdbcType=CHAR}");
        }
        
        if (record.getProjguid() != null) {
            VALUES("ProjGUID", "#{projguid,jdbcType=CHAR}");
        }
        
        if (record.getBldguid() != null) {
            VALUES("BldGUID", "#{bldguid,jdbcType=CHAR}");
        }
        
        if (record.getMainroomguid() != null) {
            VALUES("MainRoomGUID", "#{mainroomguid,jdbcType=CHAR}");
        }
        
        if (record.getUnit() != null) {
            VALUES("Unit", "#{unit,jdbcType=VARCHAR}");
        }
        
        if (record.getFloor() != null) {
            VALUES("Floor", "#{floor,jdbcType=VARCHAR}");
        }
        
        if (record.getNo() != null) {
            VALUES("No", "#{no,jdbcType=VARCHAR}");
        }
        
        if (record.getRoom() != null) {
            VALUES("Room", "#{room,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomcode() != null) {
            VALUES("RoomCode", "#{roomcode,jdbcType=VARCHAR}");
        }
        
        if (record.getHuxing() != null) {
            VALUES("HuXing", "#{huxing,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("Status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getIsvirtualroom() != null) {
            VALUES("IsVirtualRoom", "#{isvirtualroom,jdbcType=TINYINT}");
        }
        
        if (record.getBldarea() != null) {
            VALUES("BldArea", "#{bldarea,jdbcType=DECIMAL}");
        }
        
        if (record.getTnarea() != null) {
            VALUES("TnArea", "#{tnarea,jdbcType=DECIMAL}");
        }
        
        if (record.getBlrhdate() != null) {
            VALUES("BlRhDate", "#{blrhdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRhblzt() != null) {
            VALUES("RHBLZT", "#{rhblzt,jdbcType=VARCHAR}");
        }
        
        if (record.getYfbz() != null) {
            VALUES("YFBZ", "#{yfbz,jdbcType=VARCHAR}");
        }
        
        if (record.getXpos() != null) {
            VALUES("XPos", "#{xpos,jdbcType=INTEGER}");
        }
        
        if (record.getYpos() != null) {
            VALUES("YPos", "#{ypos,jdbcType=INTEGER}");
        }
        
        if (record.getZxbz() != null) {
            VALUES("ZxBz", "#{zxbz,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            VALUES("Price", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getTnprice() != null) {
            VALUES("TnPrice", "#{tnprice,jdbcType=DECIMAL}");
        }
        
        if (record.getTotal() != null) {
            VALUES("Total", "#{total,jdbcType=DECIMAL}");
        }
        
        if (record.getZxprice() != null) {
            VALUES("ZxPrice", "#{zxprice,jdbcType=DECIMAL}");
        }
        
        if (record.getZxtotal() != null) {
            VALUES("ZxTotal", "#{zxtotal,jdbcType=DECIMAL}");
        }
        
        if (record.getIstempletroom() != null) {
            VALUES("IsTempletRoom", "#{istempletroom,jdbcType=TINYINT}");
        }
        
        if (record.getLocker() != null) {
            VALUES("Locker", "#{locker,jdbcType=VARCHAR}");
        }
        
        if (record.getLocktime() != null) {
            VALUES("LockTime", "#{locktime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTfdate() != null) {
            VALUES("TfDate", "#{tfdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDjarea() != null) {
            VALUES("DjArea", "#{djarea,jdbcType=VARCHAR}");
        }
        
        if (record.getIsareamodify() != null) {
            VALUES("IsAreaModify", "#{isareamodify,jdbcType=TINYINT}");
        }
        
        if (record.getVirtualstatus() != null) {
            VALUES("VirtualStatus", "#{virtualstatus,jdbcType=VARCHAR}");
        }
        
        if (record.getRhdate() != null) {
            VALUES("RHDate", "#{rhdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getJfrq() != null) {
            VALUES("JFRQ", "#{jfrq,jdbcType=TIMESTAMP}");
        }
        
        if (record.getXkrow() != null) {
            VALUES("XkRow", "#{xkrow,jdbcType=VARCHAR}");
        }
        
        if (record.getXkcol() != null) {
            VALUES("XkCol", "#{xkcol,jdbcType=VARCHAR}");
        }
        
        if (record.getAreastatus() != null) {
            VALUES("AreaStatus", "#{areastatus,jdbcType=VARCHAR}");
        }
        
        if (record.getWest() != null) {
            VALUES("West", "#{west,jdbcType=VARCHAR}");
        }
        
        if (record.getAreachangingguid() != null) {
            VALUES("AreaChangingGUID", "#{areachangingguid,jdbcType=CHAR}");
        }
        
        if (record.getImportdate() != null) {
            VALUES("ImportDate", "#{importdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getChooseroom() != null) {
            VALUES("ChooseRoom", "#{chooseroom,jdbcType=TINYINT}");
        }
        
        if (record.getCstname() != null) {
            VALUES("CstName", "#{cstname,jdbcType=VARCHAR}");
        }
        
        if (record.getCstguidlist() != null) {
            VALUES("CstGUIDList", "#{cstguidlist,jdbcType=VARCHAR}");
        }
        
        if (record.getChooseroomcstname() != null) {
            VALUES("ChooseRoomCstName", "#{chooseroomcstname,jdbcType=VARCHAR}");
        }
        
        if (record.getChooseroomdate() != null) {
            VALUES("ChooseRoomDate", "#{chooseroomdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getJbr() != null) {
            VALUES("Jbr", "#{jbr,jdbcType=VARCHAR}");
        }
        
        if (record.getIsannexe() != null) {
            VALUES("isAnnexe", "#{isannexe,jdbcType=TINYINT}");
        }
        
        if (record.getSight() != null) {
            VALUES("Sight", "#{sight,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomstru() != null) {
            VALUES("RoomStru", "#{roomstru,jdbcType=VARCHAR}");
        }
        
        if (record.getAbsolutelyfloor() != null) {
            VALUES("AbsolutelyFloor", "#{absolutelyfloor,jdbcType=VARCHAR}");
        }
        
        if (record.getStatuschgguid() != null) {
            VALUES("StatusChgGUID", "#{statuschgguid,jdbcType=CHAR}");
        }
        
        if (record.getSalerentable() != null) {
            VALUES("SaleRentable", "#{salerentable,jdbcType=VARCHAR}");
        }
        
        if (record.getRentprice() != null) {
            VALUES("RentPrice", "#{rentprice,jdbcType=DECIMAL}");
        }
        
        if (record.getCalcrentmode() != null) {
            VALUES("CalcRentMode", "#{calcrentmode,jdbcType=VARCHAR}");
        }
        
        if (record.getRentunit() != null) {
            VALUES("RentUnit", "#{rentunit,jdbcType=VARCHAR}");
        }
        
        if (record.getBz() != null) {
            VALUES("Bz", "#{bz,jdbcType=VARCHAR}");
        }
        
        if (record.getRentstatus() != null) {
            VALUES("RentStatus", "#{rentstatus,jdbcType=VARCHAR}");
        }
        
        if (record.getContinuerentstatus() != null) {
            VALUES("ContinueRentStatus", "#{continuerentstatus,jdbcType=VARCHAR}");
        }
        
        if (record.getNextrentstatus() != null) {
            VALUES("NextRentStatus", "#{nextrentstatus,jdbcType=VARCHAR}");
        }
        
        if (record.getRentname() != null) {
            VALUES("RentName", "#{rentname,jdbcType=VARCHAR}");
        }
        
        if (record.getRentguidlist() != null) {
            VALUES("RentGUIDList", "#{rentguidlist,jdbcType=VARCHAR}");
        }
        
        if (record.getRentstatuschgguid() != null) {
            VALUES("RentStatusChgGUID", "#{rentstatuschgguid,jdbcType=CHAR}");
        }
        
        if (record.getRentlocker() != null) {
            VALUES("RentLocker", "#{rentlocker,jdbcType=VARCHAR}");
        }
        
        if (record.getRentlocktime() != null) {
            VALUES("RentLockTime", "#{rentlocktime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRentamount() != null) {
            VALUES("RentAmount", "#{rentamount,jdbcType=DECIMAL}");
        }
        
        if (record.getBproducttypecode() != null) {
            VALUES("BProductTypeCode", "#{bproducttypecode,jdbcType=VARCHAR}");
        }
        
        if (record.getYsbldarea() != null) {
            VALUES("YsBldArea", "#{ysbldarea,jdbcType=DECIMAL}");
        }
        
        if (record.getYstnarea() != null) {
            VALUES("YsTnArea", "#{ystnarea,jdbcType=DECIMAL}");
        }
        
        if (record.getScbldarea() != null) {
            VALUES("ScBldArea", "#{scbldarea,jdbcType=DECIMAL}");
        }
        
        if (record.getSctnarea() != null) {
            VALUES("ScTnArea", "#{sctnarea,jdbcType=DECIMAL}");
        }
        
        if (record.getChooseroomno() != null) {
            VALUES("ChooseRoomNo", "#{chooseroomno,jdbcType=INTEGER}");
        }
        
        if (record.getImportdataSp5() != null) {
            VALUES("ImportData_SP5", "#{importdataSp5,jdbcType=VARCHAR}");
        }
        
        if (record.getFloorno() != null) {
            VALUES("FloorNo", "#{floorno,jdbcType=INTEGER}");
        }
        
        if (record.getUnitno() != null) {
            VALUES("UnitNo", "#{unitno,jdbcType=INTEGER}");
        }
        
        if (record.getSlcontroldate() != null) {
            VALUES("SLControlDate", "#{slcontroldate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIshflock() != null) {
            VALUES("IsHfLock", "#{ishflock,jdbcType=TINYINT}");
        }
        
        if (record.getPricedj() != null) {
            VALUES("PriceDj", "#{pricedj,jdbcType=DECIMAL}");
        }
        
        if (record.getTnpricedj() != null) {
            VALUES("TnPriceDj", "#{tnpricedj,jdbcType=DECIMAL}");
        }
        
        if (record.getTotaldj() != null) {
            VALUES("TotalDj", "#{totaldj,jdbcType=DECIMAL}");
        }
        
        if (record.getIsdj2arealock() != null) {
            VALUES("IsDj2AreaLock", "#{isdj2arealock,jdbcType=TINYINT}");
        }
        
        if (record.getIsbzj2arealock() != null) {
            VALUES("IsBzj2AreaLock", "#{isbzj2arealock,jdbcType=TINYINT}");
        }
        
        if (record.getIsdjtf() != null) {
            VALUES("IsDjTf", "#{isdjtf,jdbcType=TINYINT}");
        }
        
        if (record.getIsbzjtf() != null) {
            VALUES("IsBzjTf", "#{isbzjtf,jdbcType=TINYINT}");
        }
        
        if (record.getIsdjareamodify() != null) {
            VALUES("IsDjAreaModify", "#{isdjareamodify,jdbcType=TINYINT}");
        }
        
        if (record.getChooseroombookingguid() != null) {
            VALUES("ChooseRoomBookingGUID", "#{chooseroombookingguid,jdbcType=CHAR}");
        }
        
        if (record.getVisible() != null) {
            VALUES("Visible", "#{visible,jdbcType=INTEGER}");
        }
        
        if (record.getIsyl() != null) {
            VALUES("isyl", "#{isyl,jdbcType=INTEGER}");
        }
        
        if (record.getRoombz() != null) {
            VALUES("roombz", "#{roombz,jdbcType=VARCHAR}");
        }
        
        if (record.getPreroomguid() != null) {
            VALUES("PreRoomGUID", "#{preroomguid,jdbcType=VARCHAR}");
        }
        
        if (record.getFloorguid() != null) {
            VALUES("FloorGUID", "#{floorguid,jdbcType=CHAR}");
        }
        
        if (record.getUnitguid() != null) {
            VALUES("UnitGUID", "#{unitguid,jdbcType=CHAR}");
        }
        
        if (record.getResourcestypeguid() != null) {
            VALUES("ResourcesTypeGUID", "#{resourcestypeguid,jdbcType=CHAR}");
        }
        
        if (record.getCurrentstatus() != null) {
            VALUES("CurRentStatus", "#{currentstatus,jdbcType=TINYINT}");
        }
        
        if (record.getRoomstatus() != null) {
            VALUES("RoomStatus", "#{roomstatus,jdbcType=TINYINT}");
        }
        
        if (record.getCg() != null) {
            VALUES("Cg", "#{cg,jdbcType=VARCHAR}");
        }
        
        if (record.getHz() != null) {
            VALUES("Hz", "#{hz,jdbcType=VARCHAR}");
        }
        
        if (record.getPower() != null) {
            VALUES("Power", "#{power,jdbcType=VARCHAR}");
        }
        
        if (record.getGas() != null) {
            VALUES("Gas", "#{gas,jdbcType=VARCHAR}");
        }
        
        if (record.getGs() != null) {
            VALUES("Gs", "#{gs,jdbcType=VARCHAR}");
        }
        
        if (record.getPs() != null) {
            VALUES("Ps", "#{ps,jdbcType=VARCHAR}");
        }
        
        if (record.getKt() != null) {
            VALUES("Kt", "#{kt,jdbcType=VARCHAR}");
        }
        
        if (record.getOther() != null) {
            VALUES("Other", "#{other,jdbcType=VARCHAR}");
        }
        
        if (record.getYjqydate() != null) {
            VALUES("YJQYDate", "#{yjqydate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreatedate() != null) {
            VALUES("CreateDate", "#{createdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsalowin() != null) {
            VALUES("IsAlowIn", "#{isalowin,jdbcType=TINYINT}");
        }
        
        if (record.getClient() != null) {
            VALUES("Client", "#{client,jdbcType=VARCHAR}");
        }
        
        if (record.getEntrustdate() != null) {
            VALUES("EntrustDate", "#{entrustdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEntrustjbr() != null) {
            VALUES("EntrustJbr", "#{entrustjbr,jdbcType=VARCHAR}");
        }
        
        if (record.getEntrustjbdate() != null) {
            VALUES("EntrustJbDate", "#{entrustjbdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEntrustenddate() != null) {
            VALUES("EntrustEndDate", "#{entrustenddate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContact() != null) {
            VALUES("Contact", "#{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getEntrustjbrguid() != null) {
            VALUES("EntrustJbrGUID", "#{entrustjbrguid,jdbcType=CHAR}");
        }
        
        if (record.getRoominfo() != null) {
            VALUES("RoomInfo", "#{roominfo,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomshortinfo() != null) {
            VALUES("RoomShortInfo", "#{roomshortinfo,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomsort() != null) {
            VALUES("RoomSort", "#{roomsort,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomzlbz() != null) {
            VALUES("RoomZlBz", "#{roomzlbz,jdbcType=VARCHAR}");
        }
        
        if (record.getErpcode() != null) {
            VALUES("ERPCode", "#{erpcode,jdbcType=VARCHAR}");
        }
        
        if (record.getIstransfererpcode() != null) {
            VALUES("IsTransferERPCode", "#{istransfererpcode,jdbcType=TINYINT}");
        }
        
        if (record.getErpcodeapprovestate() != null) {
            VALUES("ERPCodeApproveState", "#{erpcodeapprovestate,jdbcType=VARCHAR}");
        }
        
        if (record.getVirtualaccount() != null) {
            VALUES("VirtualAccount", "#{virtualaccount,jdbcType=VARCHAR}");
        }
        
        if (record.getSalestatus() != null) {
            VALUES("SaleStatus", "#{salestatus,jdbcType=VARCHAR}");
        }
        
        if (record.getShortunitno() != null) {
            VALUES("ShortUnitNo", "#{shortunitno,jdbcType=VARCHAR}");
        }
        
        if (record.getShortvirtualaccount() != null) {
            VALUES("ShortVirtualAccount", "#{shortvirtualaccount,jdbcType=VARCHAR}");
        }
        
        if (record.getRoommemo() != null) {
            VALUES("RoomMemo", "#{roommemo,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getJfmemo() != null) {
            VALUES("JFMemo", "#{jfmemo,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getReturnmsg() != null) {
            VALUES("ReturnMsg", "#{returnmsg,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(PRoom record) {
        BEGIN();
        UPDATE("p_Room");
        
        if (record.getBuguid() != null) {
            SET("BUGUID = #{buguid,jdbcType=CHAR}");
        }
        
        if (record.getProjguid() != null) {
            SET("ProjGUID = #{projguid,jdbcType=CHAR}");
        }
        
        if (record.getBldguid() != null) {
            SET("BldGUID = #{bldguid,jdbcType=CHAR}");
        }
        
        if (record.getMainroomguid() != null) {
            SET("MainRoomGUID = #{mainroomguid,jdbcType=CHAR}");
        }
        
        if (record.getUnit() != null) {
            SET("Unit = #{unit,jdbcType=VARCHAR}");
        }
        
        if (record.getFloor() != null) {
            SET("Floor = #{floor,jdbcType=VARCHAR}");
        }
        
        if (record.getNo() != null) {
            SET("No = #{no,jdbcType=VARCHAR}");
        }
        
        if (record.getRoom() != null) {
            SET("Room = #{room,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomcode() != null) {
            SET("RoomCode = #{roomcode,jdbcType=VARCHAR}");
        }
        
        if (record.getHuxing() != null) {
            SET("HuXing = #{huxing,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("Status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getIsvirtualroom() != null) {
            SET("IsVirtualRoom = #{isvirtualroom,jdbcType=TINYINT}");
        }
        
        if (record.getBldarea() != null) {
            SET("BldArea = #{bldarea,jdbcType=DECIMAL}");
        }
        
        if (record.getTnarea() != null) {
            SET("TnArea = #{tnarea,jdbcType=DECIMAL}");
        }
        
        if (record.getBlrhdate() != null) {
            SET("BlRhDate = #{blrhdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRhblzt() != null) {
            SET("RHBLZT = #{rhblzt,jdbcType=VARCHAR}");
        }
        
        if (record.getYfbz() != null) {
            SET("YFBZ = #{yfbz,jdbcType=VARCHAR}");
        }
        
        if (record.getXpos() != null) {
            SET("XPos = #{xpos,jdbcType=INTEGER}");
        }
        
        if (record.getYpos() != null) {
            SET("YPos = #{ypos,jdbcType=INTEGER}");
        }
        
        if (record.getZxbz() != null) {
            SET("ZxBz = #{zxbz,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            SET("Price = #{price,jdbcType=DECIMAL}");
        }
        
        if (record.getTnprice() != null) {
            SET("TnPrice = #{tnprice,jdbcType=DECIMAL}");
        }
        
        if (record.getTotal() != null) {
            SET("Total = #{total,jdbcType=DECIMAL}");
        }
        
        if (record.getZxprice() != null) {
            SET("ZxPrice = #{zxprice,jdbcType=DECIMAL}");
        }
        
        if (record.getZxtotal() != null) {
            SET("ZxTotal = #{zxtotal,jdbcType=DECIMAL}");
        }
        
        if (record.getIstempletroom() != null) {
            SET("IsTempletRoom = #{istempletroom,jdbcType=TINYINT}");
        }
        
        if (record.getLocker() != null) {
            SET("Locker = #{locker,jdbcType=VARCHAR}");
        }
        
        if (record.getLocktime() != null) {
            SET("LockTime = #{locktime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTfdate() != null) {
            SET("TfDate = #{tfdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDjarea() != null) {
            SET("DjArea = #{djarea,jdbcType=VARCHAR}");
        }
        
        if (record.getIsareamodify() != null) {
            SET("IsAreaModify = #{isareamodify,jdbcType=TINYINT}");
        }
        
        if (record.getVirtualstatus() != null) {
            SET("VirtualStatus = #{virtualstatus,jdbcType=VARCHAR}");
        }
        
        if (record.getRhdate() != null) {
            SET("RHDate = #{rhdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getJfrq() != null) {
            SET("JFRQ = #{jfrq,jdbcType=TIMESTAMP}");
        }
        
        if (record.getXkrow() != null) {
            SET("XkRow = #{xkrow,jdbcType=VARCHAR}");
        }
        
        if (record.getXkcol() != null) {
            SET("XkCol = #{xkcol,jdbcType=VARCHAR}");
        }
        
        if (record.getAreastatus() != null) {
            SET("AreaStatus = #{areastatus,jdbcType=VARCHAR}");
        }
        
        if (record.getWest() != null) {
            SET("West = #{west,jdbcType=VARCHAR}");
        }
        
        if (record.getAreachangingguid() != null) {
            SET("AreaChangingGUID = #{areachangingguid,jdbcType=CHAR}");
        }
        
        if (record.getImportdate() != null) {
            SET("ImportDate = #{importdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getChooseroom() != null) {
            SET("ChooseRoom = #{chooseroom,jdbcType=TINYINT}");
        }
        
        if (record.getCstname() != null) {
            SET("CstName = #{cstname,jdbcType=VARCHAR}");
        }
        
        if (record.getCstguidlist() != null) {
            SET("CstGUIDList = #{cstguidlist,jdbcType=VARCHAR}");
        }
        
        if (record.getChooseroomcstname() != null) {
            SET("ChooseRoomCstName = #{chooseroomcstname,jdbcType=VARCHAR}");
        }
        
        if (record.getChooseroomdate() != null) {
            SET("ChooseRoomDate = #{chooseroomdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getJbr() != null) {
            SET("Jbr = #{jbr,jdbcType=VARCHAR}");
        }
        
        if (record.getIsannexe() != null) {
            SET("isAnnexe = #{isannexe,jdbcType=TINYINT}");
        }
        
        if (record.getSight() != null) {
            SET("Sight = #{sight,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomstru() != null) {
            SET("RoomStru = #{roomstru,jdbcType=VARCHAR}");
        }
        
        if (record.getAbsolutelyfloor() != null) {
            SET("AbsolutelyFloor = #{absolutelyfloor,jdbcType=VARCHAR}");
        }
        
        if (record.getStatuschgguid() != null) {
            SET("StatusChgGUID = #{statuschgguid,jdbcType=CHAR}");
        }
        
        if (record.getSalerentable() != null) {
            SET("SaleRentable = #{salerentable,jdbcType=VARCHAR}");
        }
        
        if (record.getRentprice() != null) {
            SET("RentPrice = #{rentprice,jdbcType=DECIMAL}");
        }
        
        if (record.getCalcrentmode() != null) {
            SET("CalcRentMode = #{calcrentmode,jdbcType=VARCHAR}");
        }
        
        if (record.getRentunit() != null) {
            SET("RentUnit = #{rentunit,jdbcType=VARCHAR}");
        }
        
        if (record.getBz() != null) {
            SET("Bz = #{bz,jdbcType=VARCHAR}");
        }
        
        if (record.getRentstatus() != null) {
            SET("RentStatus = #{rentstatus,jdbcType=VARCHAR}");
        }
        
        if (record.getContinuerentstatus() != null) {
            SET("ContinueRentStatus = #{continuerentstatus,jdbcType=VARCHAR}");
        }
        
        if (record.getNextrentstatus() != null) {
            SET("NextRentStatus = #{nextrentstatus,jdbcType=VARCHAR}");
        }
        
        if (record.getRentname() != null) {
            SET("RentName = #{rentname,jdbcType=VARCHAR}");
        }
        
        if (record.getRentguidlist() != null) {
            SET("RentGUIDList = #{rentguidlist,jdbcType=VARCHAR}");
        }
        
        if (record.getRentstatuschgguid() != null) {
            SET("RentStatusChgGUID = #{rentstatuschgguid,jdbcType=CHAR}");
        }
        
        if (record.getRentlocker() != null) {
            SET("RentLocker = #{rentlocker,jdbcType=VARCHAR}");
        }
        
        if (record.getRentlocktime() != null) {
            SET("RentLockTime = #{rentlocktime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRentamount() != null) {
            SET("RentAmount = #{rentamount,jdbcType=DECIMAL}");
        }
        
        if (record.getBproducttypecode() != null) {
            SET("BProductTypeCode = #{bproducttypecode,jdbcType=VARCHAR}");
        }
        
        if (record.getYsbldarea() != null) {
            SET("YsBldArea = #{ysbldarea,jdbcType=DECIMAL}");
        }
        
        if (record.getYstnarea() != null) {
            SET("YsTnArea = #{ystnarea,jdbcType=DECIMAL}");
        }
        
        if (record.getScbldarea() != null) {
            SET("ScBldArea = #{scbldarea,jdbcType=DECIMAL}");
        }
        
        if (record.getSctnarea() != null) {
            SET("ScTnArea = #{sctnarea,jdbcType=DECIMAL}");
        }
        
        if (record.getChooseroomno() != null) {
            SET("ChooseRoomNo = #{chooseroomno,jdbcType=INTEGER}");
        }
        
        if (record.getImportdataSp5() != null) {
            SET("ImportData_SP5 = #{importdataSp5,jdbcType=VARCHAR}");
        }
        
        if (record.getFloorno() != null) {
            SET("FloorNo = #{floorno,jdbcType=INTEGER}");
        }
        
        if (record.getUnitno() != null) {
            SET("UnitNo = #{unitno,jdbcType=INTEGER}");
        }
        
        if (record.getSlcontroldate() != null) {
            SET("SLControlDate = #{slcontroldate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIshflock() != null) {
            SET("IsHfLock = #{ishflock,jdbcType=TINYINT}");
        }
        
        if (record.getPricedj() != null) {
            SET("PriceDj = #{pricedj,jdbcType=DECIMAL}");
        }
        
        if (record.getTnpricedj() != null) {
            SET("TnPriceDj = #{tnpricedj,jdbcType=DECIMAL}");
        }
        
        if (record.getTotaldj() != null) {
            SET("TotalDj = #{totaldj,jdbcType=DECIMAL}");
        }
        
        if (record.getIsdj2arealock() != null) {
            SET("IsDj2AreaLock = #{isdj2arealock,jdbcType=TINYINT}");
        }
        
        if (record.getIsbzj2arealock() != null) {
            SET("IsBzj2AreaLock = #{isbzj2arealock,jdbcType=TINYINT}");
        }
        
        if (record.getIsdjtf() != null) {
            SET("IsDjTf = #{isdjtf,jdbcType=TINYINT}");
        }
        
        if (record.getIsbzjtf() != null) {
            SET("IsBzjTf = #{isbzjtf,jdbcType=TINYINT}");
        }
        
        if (record.getIsdjareamodify() != null) {
            SET("IsDjAreaModify = #{isdjareamodify,jdbcType=TINYINT}");
        }
        
        if (record.getChooseroombookingguid() != null) {
            SET("ChooseRoomBookingGUID = #{chooseroombookingguid,jdbcType=CHAR}");
        }
        
        if (record.getVisible() != null) {
            SET("Visible = #{visible,jdbcType=INTEGER}");
        }
        
        if (record.getIsyl() != null) {
            SET("isyl = #{isyl,jdbcType=INTEGER}");
        }
        
        if (record.getRoombz() != null) {
            SET("roombz = #{roombz,jdbcType=VARCHAR}");
        }
        
        if (record.getPreroomguid() != null) {
            SET("PreRoomGUID = #{preroomguid,jdbcType=VARCHAR}");
        }
        
        if (record.getFloorguid() != null) {
            SET("FloorGUID = #{floorguid,jdbcType=CHAR}");
        }
        
        if (record.getUnitguid() != null) {
            SET("UnitGUID = #{unitguid,jdbcType=CHAR}");
        }
        
        if (record.getResourcestypeguid() != null) {
            SET("ResourcesTypeGUID = #{resourcestypeguid,jdbcType=CHAR}");
        }
        
        if (record.getCurrentstatus() != null) {
            SET("CurRentStatus = #{currentstatus,jdbcType=TINYINT}");
        }
        
        if (record.getRoomstatus() != null) {
            SET("RoomStatus = #{roomstatus,jdbcType=TINYINT}");
        }
        
        if (record.getCg() != null) {
            SET("Cg = #{cg,jdbcType=VARCHAR}");
        }
        
        if (record.getHz() != null) {
            SET("Hz = #{hz,jdbcType=VARCHAR}");
        }
        
        if (record.getPower() != null) {
            SET("Power = #{power,jdbcType=VARCHAR}");
        }
        
        if (record.getGas() != null) {
            SET("Gas = #{gas,jdbcType=VARCHAR}");
        }
        
        if (record.getGs() != null) {
            SET("Gs = #{gs,jdbcType=VARCHAR}");
        }
        
        if (record.getPs() != null) {
            SET("Ps = #{ps,jdbcType=VARCHAR}");
        }
        
        if (record.getKt() != null) {
            SET("Kt = #{kt,jdbcType=VARCHAR}");
        }
        
        if (record.getOther() != null) {
            SET("Other = #{other,jdbcType=VARCHAR}");
        }
        
        if (record.getYjqydate() != null) {
            SET("YJQYDate = #{yjqydate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreatedate() != null) {
            SET("CreateDate = #{createdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsalowin() != null) {
            SET("IsAlowIn = #{isalowin,jdbcType=TINYINT}");
        }
        
        if (record.getClient() != null) {
            SET("Client = #{client,jdbcType=VARCHAR}");
        }
        
        if (record.getEntrustdate() != null) {
            SET("EntrustDate = #{entrustdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEntrustjbr() != null) {
            SET("EntrustJbr = #{entrustjbr,jdbcType=VARCHAR}");
        }
        
        if (record.getEntrustjbdate() != null) {
            SET("EntrustJbDate = #{entrustjbdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEntrustenddate() != null) {
            SET("EntrustEndDate = #{entrustenddate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContact() != null) {
            SET("Contact = #{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getEntrustjbrguid() != null) {
            SET("EntrustJbrGUID = #{entrustjbrguid,jdbcType=CHAR}");
        }
        
        if (record.getRoominfo() != null) {
            SET("RoomInfo = #{roominfo,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomshortinfo() != null) {
            SET("RoomShortInfo = #{roomshortinfo,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomsort() != null) {
            SET("RoomSort = #{roomsort,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomzlbz() != null) {
            SET("RoomZlBz = #{roomzlbz,jdbcType=VARCHAR}");
        }
        
        if (record.getErpcode() != null) {
            SET("ERPCode = #{erpcode,jdbcType=VARCHAR}");
        }
        
        if (record.getIstransfererpcode() != null) {
            SET("IsTransferERPCode = #{istransfererpcode,jdbcType=TINYINT}");
        }
        
        if (record.getErpcodeapprovestate() != null) {
            SET("ERPCodeApproveState = #{erpcodeapprovestate,jdbcType=VARCHAR}");
        }
        
        if (record.getVirtualaccount() != null) {
            SET("VirtualAccount = #{virtualaccount,jdbcType=VARCHAR}");
        }
        
        if (record.getSalestatus() != null) {
            SET("SaleStatus = #{salestatus,jdbcType=VARCHAR}");
        }
        
        if (record.getShortunitno() != null) {
            SET("ShortUnitNo = #{shortunitno,jdbcType=VARCHAR}");
        }
        
        if (record.getShortvirtualaccount() != null) {
            SET("ShortVirtualAccount = #{shortvirtualaccount,jdbcType=VARCHAR}");
        }
        
        if (record.getRoommemo() != null) {
            SET("RoomMemo = #{roommemo,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getJfmemo() != null) {
            SET("JFMemo = #{jfmemo,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getReturnmsg() != null) {
            SET("ReturnMsg = #{returnmsg,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("RoomGUID = #{roomguid,jdbcType=CHAR}");
        
        return SQL();
    }
}