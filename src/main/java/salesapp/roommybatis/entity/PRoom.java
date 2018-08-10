package salesapp.roommybatis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PRoom implements Serializable {
    private String roomguid;

    private String buguid;

    private String projguid;

    private String bldguid;

    private String mainroomguid;

    private String unit;

    private String floor;

    private String no;

    private String room;

    private String roomcode;

    private String huxing;

    private String status;

    private Byte isvirtualroom;

    private BigDecimal bldarea;

    private BigDecimal tnarea;

    private Date blrhdate;

    private String rhblzt;

    private String yfbz;

    private Integer xpos;

    private Integer ypos;

    private String zxbz;

    private BigDecimal price;

    private BigDecimal tnprice;

    private BigDecimal total;

    private BigDecimal zxprice;

    private BigDecimal zxtotal;

    private Byte istempletroom;

    private String locker;

    private Date locktime;

    private Date tfdate;

    private String djarea;

    private Byte isareamodify;

    private String virtualstatus;

    private Date rhdate;

    private Date jfrq;

    private String xkrow;

    private String xkcol;

    private String areastatus;

    private String west;

    private String areachangingguid;

    private Date importdate;

    private Byte chooseroom;

    private String cstname;

    private String cstguidlist;

    private String chooseroomcstname;

    private Date chooseroomdate;

    private String jbr;

    private Byte isannexe;

    private String sight;

    private String roomstru;

    private String absolutelyfloor;

    private String statuschgguid;

    private String salerentable;

    private BigDecimal rentprice;

    private String calcrentmode;

    private String rentunit;

    private String bz;

    private String rentstatus;

    private String continuerentstatus;

    private String nextrentstatus;

    private String rentname;

    private String rentguidlist;

    private String rentstatuschgguid;

    private String rentlocker;

    private Date rentlocktime;

    private BigDecimal rentamount;

    private String bproducttypecode;

    private BigDecimal ysbldarea;

    private BigDecimal ystnarea;

    private BigDecimal scbldarea;

    private BigDecimal sctnarea;

    private Integer chooseroomno;

    private String importdataSp5;

    private Integer floorno;

    private Integer unitno;

    private Date slcontroldate;

    private Byte ishflock;

    private BigDecimal pricedj;

    private BigDecimal tnpricedj;

    private BigDecimal totaldj;

    private Byte isdj2arealock;

    private Byte isbzj2arealock;

    private Byte isdjtf;

    private Byte isbzjtf;

    private Byte isdjareamodify;

    private String chooseroombookingguid;

    private Integer visible;

    private Integer isyl;

    private String roombz;

    private String preroomguid;

    private String floorguid;

    private String unitguid;

    private String resourcestypeguid;

    private Byte currentstatus;

    private Byte roomstatus;

    private String cg;

    private String hz;

    private String power;

    private String gas;

    private String gs;

    private String ps;

    private String kt;

    private String other;

    private Date yjqydate;

    private Date createdate;

    private Byte isalowin;

    private String client;

    private Date entrustdate;

    private String entrustjbr;

    private Date entrustjbdate;

    private Date entrustenddate;

    private String contact;

    private String entrustjbrguid;

    private String roominfo;

    private String roomshortinfo;

    private String roomsort;

    private String roomzlbz;

    private String erpcode;

    private Byte istransfererpcode;

    private String erpcodeapprovestate;

    private String virtualaccount;

    private String salestatus;

    private String shortunitno;

    private String shortvirtualaccount;

    private String roommemo;

    private String jfmemo;

    private String returnmsg;

    private static final long serialVersionUID = 1L;

    public String getRoomguid() {
        return roomguid;
    }

    public void setRoomguid(String roomguid) {
        this.roomguid = roomguid;
    }

    public String getBuguid() {
        return buguid;
    }

    public void setBuguid(String buguid) {
        this.buguid = buguid;
    }

    public String getProjguid() {
        return projguid;
    }

    public void setProjguid(String projguid) {
        this.projguid = projguid;
    }

    public String getBldguid() {
        return bldguid;
    }

    public void setBldguid(String bldguid) {
        this.bldguid = bldguid;
    }

    public String getMainroomguid() {
        return mainroomguid;
    }

    public void setMainroomguid(String mainroomguid) {
        this.mainroomguid = mainroomguid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoomcode() {
        return roomcode;
    }

    public void setRoomcode(String roomcode) {
        this.roomcode = roomcode;
    }

    public String getHuxing() {
        return huxing;
    }

    public void setHuxing(String huxing) {
        this.huxing = huxing;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Byte getIsvirtualroom() {
        return isvirtualroom;
    }

    public void setIsvirtualroom(Byte isvirtualroom) {
        this.isvirtualroom = isvirtualroom;
    }

    public BigDecimal getBldarea() {
        return bldarea;
    }

    public void setBldarea(BigDecimal bldarea) {
        this.bldarea = bldarea;
    }

    public BigDecimal getTnarea() {
        return tnarea;
    }

    public void setTnarea(BigDecimal tnarea) {
        this.tnarea = tnarea;
    }

    public Date getBlrhdate() {
        return blrhdate;
    }

    public void setBlrhdate(Date blrhdate) {
        this.blrhdate = blrhdate;
    }

    public String getRhblzt() {
        return rhblzt;
    }

    public void setRhblzt(String rhblzt) {
        this.rhblzt = rhblzt;
    }

    public String getYfbz() {
        return yfbz;
    }

    public void setYfbz(String yfbz) {
        this.yfbz = yfbz;
    }

    public Integer getXpos() {
        return xpos;
    }

    public void setXpos(Integer xpos) {
        this.xpos = xpos;
    }

    public Integer getYpos() {
        return ypos;
    }

    public void setYpos(Integer ypos) {
        this.ypos = ypos;
    }

    public String getZxbz() {
        return zxbz;
    }

    public void setZxbz(String zxbz) {
        this.zxbz = zxbz;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTnprice() {
        return tnprice;
    }

    public void setTnprice(BigDecimal tnprice) {
        this.tnprice = tnprice;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getZxprice() {
        return zxprice;
    }

    public void setZxprice(BigDecimal zxprice) {
        this.zxprice = zxprice;
    }

    public BigDecimal getZxtotal() {
        return zxtotal;
    }

    public void setZxtotal(BigDecimal zxtotal) {
        this.zxtotal = zxtotal;
    }

    public Byte getIstempletroom() {
        return istempletroom;
    }

    public void setIstempletroom(Byte istempletroom) {
        this.istempletroom = istempletroom;
    }

    public String getLocker() {
        return locker;
    }

    public void setLocker(String locker) {
        this.locker = locker;
    }

    public Date getLocktime() {
        return locktime;
    }

    public void setLocktime(Date locktime) {
        this.locktime = locktime;
    }

    public Date getTfdate() {
        return tfdate;
    }

    public void setTfdate(Date tfdate) {
        this.tfdate = tfdate;
    }

    public String getDjarea() {
        return djarea;
    }

    public void setDjarea(String djarea) {
        this.djarea = djarea;
    }

    public Byte getIsareamodify() {
        return isareamodify;
    }

    public void setIsareamodify(Byte isareamodify) {
        this.isareamodify = isareamodify;
    }

    public String getVirtualstatus() {
        return virtualstatus;
    }

    public void setVirtualstatus(String virtualstatus) {
        this.virtualstatus = virtualstatus;
    }

    public Date getRhdate() {
        return rhdate;
    }

    public void setRhdate(Date rhdate) {
        this.rhdate = rhdate;
    }

    public Date getJfrq() {
        return jfrq;
    }

    public void setJfrq(Date jfrq) {
        this.jfrq = jfrq;
    }

    public String getXkrow() {
        return xkrow;
    }

    public void setXkrow(String xkrow) {
        this.xkrow = xkrow;
    }

    public String getXkcol() {
        return xkcol;
    }

    public void setXkcol(String xkcol) {
        this.xkcol = xkcol;
    }

    public String getAreastatus() {
        return areastatus;
    }

    public void setAreastatus(String areastatus) {
        this.areastatus = areastatus;
    }

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }

    public String getAreachangingguid() {
        return areachangingguid;
    }

    public void setAreachangingguid(String areachangingguid) {
        this.areachangingguid = areachangingguid;
    }

    public Date getImportdate() {
        return importdate;
    }

    public void setImportdate(Date importdate) {
        this.importdate = importdate;
    }

    public Byte getChooseroom() {
        return chooseroom;
    }

    public void setChooseroom(Byte chooseroom) {
        this.chooseroom = chooseroom;
    }

    public String getCstname() {
        return cstname;
    }

    public void setCstname(String cstname) {
        this.cstname = cstname;
    }

    public String getCstguidlist() {
        return cstguidlist;
    }

    public void setCstguidlist(String cstguidlist) {
        this.cstguidlist = cstguidlist;
    }

    public String getChooseroomcstname() {
        return chooseroomcstname;
    }

    public void setChooseroomcstname(String chooseroomcstname) {
        this.chooseroomcstname = chooseroomcstname;
    }

    public Date getChooseroomdate() {
        return chooseroomdate;
    }

    public void setChooseroomdate(Date chooseroomdate) {
        this.chooseroomdate = chooseroomdate;
    }

    public String getJbr() {
        return jbr;
    }

    public void setJbr(String jbr) {
        this.jbr = jbr;
    }

    public Byte getIsannexe() {
        return isannexe;
    }

    public void setIsannexe(Byte isannexe) {
        this.isannexe = isannexe;
    }

    public String getSight() {
        return sight;
    }

    public void setSight(String sight) {
        this.sight = sight;
    }

    public String getRoomstru() {
        return roomstru;
    }

    public void setRoomstru(String roomstru) {
        this.roomstru = roomstru;
    }

    public String getAbsolutelyfloor() {
        return absolutelyfloor;
    }

    public void setAbsolutelyfloor(String absolutelyfloor) {
        this.absolutelyfloor = absolutelyfloor;
    }

    public String getStatuschgguid() {
        return statuschgguid;
    }

    public void setStatuschgguid(String statuschgguid) {
        this.statuschgguid = statuschgguid;
    }

    public String getSalerentable() {
        return salerentable;
    }

    public void setSalerentable(String salerentable) {
        this.salerentable = salerentable;
    }

    public BigDecimal getRentprice() {
        return rentprice;
    }

    public void setRentprice(BigDecimal rentprice) {
        this.rentprice = rentprice;
    }

    public String getCalcrentmode() {
        return calcrentmode;
    }

    public void setCalcrentmode(String calcrentmode) {
        this.calcrentmode = calcrentmode;
    }

    public String getRentunit() {
        return rentunit;
    }

    public void setRentunit(String rentunit) {
        this.rentunit = rentunit;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getRentstatus() {
        return rentstatus;
    }

    public void setRentstatus(String rentstatus) {
        this.rentstatus = rentstatus;
    }

    public String getContinuerentstatus() {
        return continuerentstatus;
    }

    public void setContinuerentstatus(String continuerentstatus) {
        this.continuerentstatus = continuerentstatus;
    }

    public String getNextrentstatus() {
        return nextrentstatus;
    }

    public void setNextrentstatus(String nextrentstatus) {
        this.nextrentstatus = nextrentstatus;
    }

    public String getRentname() {
        return rentname;
    }

    public void setRentname(String rentname) {
        this.rentname = rentname;
    }

    public String getRentguidlist() {
        return rentguidlist;
    }

    public void setRentguidlist(String rentguidlist) {
        this.rentguidlist = rentguidlist;
    }

    public String getRentstatuschgguid() {
        return rentstatuschgguid;
    }

    public void setRentstatuschgguid(String rentstatuschgguid) {
        this.rentstatuschgguid = rentstatuschgguid;
    }

    public String getRentlocker() {
        return rentlocker;
    }

    public void setRentlocker(String rentlocker) {
        this.rentlocker = rentlocker;
    }

    public Date getRentlocktime() {
        return rentlocktime;
    }

    public void setRentlocktime(Date rentlocktime) {
        this.rentlocktime = rentlocktime;
    }

    public BigDecimal getRentamount() {
        return rentamount;
    }

    public void setRentamount(BigDecimal rentamount) {
        this.rentamount = rentamount;
    }

    public String getBproducttypecode() {
        return bproducttypecode;
    }

    public void setBproducttypecode(String bproducttypecode) {
        this.bproducttypecode = bproducttypecode;
    }

    public BigDecimal getYsbldarea() {
        return ysbldarea;
    }

    public void setYsbldarea(BigDecimal ysbldarea) {
        this.ysbldarea = ysbldarea;
    }

    public BigDecimal getYstnarea() {
        return ystnarea;
    }

    public void setYstnarea(BigDecimal ystnarea) {
        this.ystnarea = ystnarea;
    }

    public BigDecimal getScbldarea() {
        return scbldarea;
    }

    public void setScbldarea(BigDecimal scbldarea) {
        this.scbldarea = scbldarea;
    }

    public BigDecimal getSctnarea() {
        return sctnarea;
    }

    public void setSctnarea(BigDecimal sctnarea) {
        this.sctnarea = sctnarea;
    }

    public Integer getChooseroomno() {
        return chooseroomno;
    }

    public void setChooseroomno(Integer chooseroomno) {
        this.chooseroomno = chooseroomno;
    }

    public String getImportdataSp5() {
        return importdataSp5;
    }

    public void setImportdataSp5(String importdataSp5) {
        this.importdataSp5 = importdataSp5;
    }

    public Integer getFloorno() {
        return floorno;
    }

    public void setFloorno(Integer floorno) {
        this.floorno = floorno;
    }

    public Integer getUnitno() {
        return unitno;
    }

    public void setUnitno(Integer unitno) {
        this.unitno = unitno;
    }

    public Date getSlcontroldate() {
        return slcontroldate;
    }

    public void setSlcontroldate(Date slcontroldate) {
        this.slcontroldate = slcontroldate;
    }

    public Byte getIshflock() {
        return ishflock;
    }

    public void setIshflock(Byte ishflock) {
        this.ishflock = ishflock;
    }

    public BigDecimal getPricedj() {
        return pricedj;
    }

    public void setPricedj(BigDecimal pricedj) {
        this.pricedj = pricedj;
    }

    public BigDecimal getTnpricedj() {
        return tnpricedj;
    }

    public void setTnpricedj(BigDecimal tnpricedj) {
        this.tnpricedj = tnpricedj;
    }

    public BigDecimal getTotaldj() {
        return totaldj;
    }

    public void setTotaldj(BigDecimal totaldj) {
        this.totaldj = totaldj;
    }

    public Byte getIsdj2arealock() {
        return isdj2arealock;
    }

    public void setIsdj2arealock(Byte isdj2arealock) {
        this.isdj2arealock = isdj2arealock;
    }

    public Byte getIsbzj2arealock() {
        return isbzj2arealock;
    }

    public void setIsbzj2arealock(Byte isbzj2arealock) {
        this.isbzj2arealock = isbzj2arealock;
    }

    public Byte getIsdjtf() {
        return isdjtf;
    }

    public void setIsdjtf(Byte isdjtf) {
        this.isdjtf = isdjtf;
    }

    public Byte getIsbzjtf() {
        return isbzjtf;
    }

    public void setIsbzjtf(Byte isbzjtf) {
        this.isbzjtf = isbzjtf;
    }

    public Byte getIsdjareamodify() {
        return isdjareamodify;
    }

    public void setIsdjareamodify(Byte isdjareamodify) {
        this.isdjareamodify = isdjareamodify;
    }

    public String getChooseroombookingguid() {
        return chooseroombookingguid;
    }

    public void setChooseroombookingguid(String chooseroombookingguid) {
        this.chooseroombookingguid = chooseroombookingguid;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Integer getIsyl() {
        return isyl;
    }

    public void setIsyl(Integer isyl) {
        this.isyl = isyl;
    }

    public String getRoombz() {
        return roombz;
    }

    public void setRoombz(String roombz) {
        this.roombz = roombz;
    }

    public String getPreroomguid() {
        return preroomguid;
    }

    public void setPreroomguid(String preroomguid) {
        this.preroomguid = preroomguid;
    }

    public String getFloorguid() {
        return floorguid;
    }

    public void setFloorguid(String floorguid) {
        this.floorguid = floorguid;
    }

    public String getUnitguid() {
        return unitguid;
    }

    public void setUnitguid(String unitguid) {
        this.unitguid = unitguid;
    }

    public String getResourcestypeguid() {
        return resourcestypeguid;
    }

    public void setResourcestypeguid(String resourcestypeguid) {
        this.resourcestypeguid = resourcestypeguid;
    }

    public Byte getCurrentstatus() {
        return currentstatus;
    }

    public void setCurrentstatus(Byte currentstatus) {
        this.currentstatus = currentstatus;
    }

    public Byte getRoomstatus() {
        return roomstatus;
    }

    public void setRoomstatus(Byte roomstatus) {
        this.roomstatus = roomstatus;
    }

    public String getCg() {
        return cg;
    }

    public void setCg(String cg) {
        this.cg = cg;
    }

    public String getHz() {
        return hz;
    }

    public void setHz(String hz) {
        this.hz = hz;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getGs() {
        return gs;
    }

    public void setGs(String gs) {
        this.gs = gs;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getKt() {
        return kt;
    }

    public void setKt(String kt) {
        this.kt = kt;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Date getYjqydate() {
        return yjqydate;
    }

    public void setYjqydate(Date yjqydate) {
        this.yjqydate = yjqydate;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Byte getIsalowin() {
        return isalowin;
    }

    public void setIsalowin(Byte isalowin) {
        this.isalowin = isalowin;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getEntrustdate() {
        return entrustdate;
    }

    public void setEntrustdate(Date entrustdate) {
        this.entrustdate = entrustdate;
    }

    public String getEntrustjbr() {
        return entrustjbr;
    }

    public void setEntrustjbr(String entrustjbr) {
        this.entrustjbr = entrustjbr;
    }

    public Date getEntrustjbdate() {
        return entrustjbdate;
    }

    public void setEntrustjbdate(Date entrustjbdate) {
        this.entrustjbdate = entrustjbdate;
    }

    public Date getEntrustenddate() {
        return entrustenddate;
    }

    public void setEntrustenddate(Date entrustenddate) {
        this.entrustenddate = entrustenddate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEntrustjbrguid() {
        return entrustjbrguid;
    }

    public void setEntrustjbrguid(String entrustjbrguid) {
        this.entrustjbrguid = entrustjbrguid;
    }

    public String getRoominfo() {
        return roominfo;
    }

    public void setRoominfo(String roominfo) {
        this.roominfo = roominfo;
    }

    public String getRoomshortinfo() {
        return roomshortinfo;
    }

    public void setRoomshortinfo(String roomshortinfo) {
        this.roomshortinfo = roomshortinfo;
    }

    public String getRoomsort() {
        return roomsort;
    }

    public void setRoomsort(String roomsort) {
        this.roomsort = roomsort;
    }

    public String getRoomzlbz() {
        return roomzlbz;
    }

    public void setRoomzlbz(String roomzlbz) {
        this.roomzlbz = roomzlbz;
    }

    public String getErpcode() {
        return erpcode;
    }

    public void setErpcode(String erpcode) {
        this.erpcode = erpcode;
    }

    public Byte getIstransfererpcode() {
        return istransfererpcode;
    }

    public void setIstransfererpcode(Byte istransfererpcode) {
        this.istransfererpcode = istransfererpcode;
    }

    public String getErpcodeapprovestate() {
        return erpcodeapprovestate;
    }

    public void setErpcodeapprovestate(String erpcodeapprovestate) {
        this.erpcodeapprovestate = erpcodeapprovestate;
    }

    public String getVirtualaccount() {
        return virtualaccount;
    }

    public void setVirtualaccount(String virtualaccount) {
        this.virtualaccount = virtualaccount;
    }

    public String getSalestatus() {
        return salestatus;
    }

    public void setSalestatus(String salestatus) {
        this.salestatus = salestatus;
    }

    public String getShortunitno() {
        return shortunitno;
    }

    public void setShortunitno(String shortunitno) {
        this.shortunitno = shortunitno;
    }

    public String getShortvirtualaccount() {
        return shortvirtualaccount;
    }

    public void setShortvirtualaccount(String shortvirtualaccount) {
        this.shortvirtualaccount = shortvirtualaccount;
    }

    public String getRoommemo() {
        return roommemo;
    }

    public void setRoommemo(String roommemo) {
        this.roommemo = roommemo;
    }

    public String getJfmemo() {
        return jfmemo;
    }

    public void setJfmemo(String jfmemo) {
        this.jfmemo = jfmemo;
    }

    public String getReturnmsg() {
        return returnmsg;
    }

    public void setReturnmsg(String returnmsg) {
        this.returnmsg = returnmsg;
    }
}