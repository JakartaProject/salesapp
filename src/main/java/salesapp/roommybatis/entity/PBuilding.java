package salesapp.roommybatis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PBuilding implements Serializable {
    private String bldguid;

    private String buguid;

    private String projguid;

    private String bldcode;

    private String bldname;

    private String parentcode;

    private String bldfullname;

    private Integer xpos;

    private Integer ypos;

    private String dispmode;

    private String planurl;

    private String bldproperty;

    private Integer unitnum;

    private Integer floornum;

    private Byte isbld;

    private String salerentable;

    private BigDecimal planbldarea;

    private BigDecimal factbldarea;

    private String schedulemode;

    private String areafullname;

    private String productguid;

    private Byte cqIsdt;

    private String resourcestypeguid;

    private String erpcode;

    private BigDecimal defaultdiscount;

    private Date yjjfdate;

    private String towertype;

    private String area;

    private String floorlist;

    private static final long serialVersionUID = 1L;

    public String getBldguid() {
        return bldguid;
    }

    public void setBldguid(String bldguid) {
        this.bldguid = bldguid;
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

    public String getBldcode() {
        return bldcode;
    }

    public void setBldcode(String bldcode) {
        this.bldcode = bldcode;
    }

    public String getBldname() {
        return bldname;
    }

    public void setBldname(String bldname) {
        this.bldname = bldname;
    }

    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode;
    }

    public String getBldfullname() {
        return bldfullname;
    }

    public void setBldfullname(String bldfullname) {
        this.bldfullname = bldfullname;
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

    public String getDispmode() {
        return dispmode;
    }

    public void setDispmode(String dispmode) {
        this.dispmode = dispmode;
    }

    public String getPlanurl() {
        return planurl;
    }

    public void setPlanurl(String planurl) {
        this.planurl = planurl;
    }

    public String getBldproperty() {
        return bldproperty;
    }

    public void setBldproperty(String bldproperty) {
        this.bldproperty = bldproperty;
    }

    public Integer getUnitnum() {
        return unitnum;
    }

    public void setUnitnum(Integer unitnum) {
        this.unitnum = unitnum;
    }

    public Integer getFloornum() {
        return floornum;
    }

    public void setFloornum(Integer floornum) {
        this.floornum = floornum;
    }

    public Byte getIsbld() {
        return isbld;
    }

    public void setIsbld(Byte isbld) {
        this.isbld = isbld;
    }

    public String getSalerentable() {
        return salerentable;
    }

    public void setSalerentable(String salerentable) {
        this.salerentable = salerentable;
    }

    public BigDecimal getPlanbldarea() {
        return planbldarea;
    }

    public void setPlanbldarea(BigDecimal planbldarea) {
        this.planbldarea = planbldarea;
    }

    public BigDecimal getFactbldarea() {
        return factbldarea;
    }

    public void setFactbldarea(BigDecimal factbldarea) {
        this.factbldarea = factbldarea;
    }

    public String getSchedulemode() {
        return schedulemode;
    }

    public void setSchedulemode(String schedulemode) {
        this.schedulemode = schedulemode;
    }

    public String getAreafullname() {
        return areafullname;
    }

    public void setAreafullname(String areafullname) {
        this.areafullname = areafullname;
    }

    public String getProductguid() {
        return productguid;
    }

    public void setProductguid(String productguid) {
        this.productguid = productguid;
    }

    public Byte getCqIsdt() {
        return cqIsdt;
    }

    public void setCqIsdt(Byte cqIsdt) {
        this.cqIsdt = cqIsdt;
    }

    public String getResourcestypeguid() {
        return resourcestypeguid;
    }

    public void setResourcestypeguid(String resourcestypeguid) {
        this.resourcestypeguid = resourcestypeguid;
    }

    public String getErpcode() {
        return erpcode;
    }

    public void setErpcode(String erpcode) {
        this.erpcode = erpcode;
    }

    public BigDecimal getDefaultdiscount() {
        return defaultdiscount;
    }

    public void setDefaultdiscount(BigDecimal defaultdiscount) {
        this.defaultdiscount = defaultdiscount;
    }

    public Date getYjjfdate() {
        return yjjfdate;
    }

    public void setYjjfdate(Date yjjfdate) {
        this.yjjfdate = yjjfdate;
    }

    public String getTowertype() {
        return towertype;
    }

    public void setTowertype(String towertype) {
        this.towertype = towertype;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFloorlist() {
        return floorlist;
    }

    public void setFloorlist(String floorlist) {
        this.floorlist = floorlist;
    }
}