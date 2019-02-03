package cn.xkx.vs.pojo;

public class Place {
    private Integer placeid;

    private String placename;

    private Integer capacity;

    private Integer used;

    public Integer getPlaceid() {
        return placeid;
    }

    public void setPlaceid(Integer placeid) {
        this.placeid = placeid;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename == null ? null : placename.trim();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getUse() {
        return used;
    }

    public void setUse(Integer use) {
        this.used = use;
    }
}