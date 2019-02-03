package cn.xkx.vs.pojo;

import java.util.Date;

public class HumanFlow {
    private Date currenttime;

    private Integer innum;

    private Integer outnum;

    private Integer placeid;

    private Integer curnum;

    public Date getCurrenttime() {
        return currenttime;
    }

    public void setCurrenttime(Date currenttime) {
        this.currenttime = currenttime;
    }

    public Integer getInnum() {
        return innum;
    }

    public void setInnum(Integer innum) {
        this.innum = innum;
    }

    public Integer getOutnum() {
        return outnum;
    }

    public void setOutnum(Integer outnum) {
        this.outnum = outnum;
    }

    public Integer getPlaceid() {
        return placeid;
    }

    public void setPlaceid(Integer placeid) {
        this.placeid = placeid;
    }

    public Integer getCurnum() {
        return curnum;
    }

    public void setCurnum(Integer curnum) {
        this.curnum = curnum;
    }
}