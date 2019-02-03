package cn.xkx.vs.pojo;

import java.util.Date;

public class Picture {
    private Date currenttime;

    private Integer placeid;

    private String url;

    public Date getCurrenttime() {
        return currenttime;
    }

    public void setCurrenttime(Date currenttime) {
        this.currenttime = currenttime;
    }

    public Integer getPlaceid() {
        return placeid;
    }

    public void setPlaceid(Integer placeid) {
        this.placeid = placeid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}