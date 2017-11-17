package com.gsccs.sme.plat.rtable.model;

public class WaterTake {
    private Integer id;

    private String mainid;

    private String date;

    private String waterdb;

    private String waterdx;

    private String waterzl;

    private String waterqt;

    private String waterall;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainid() {
        return mainid;
    }

    public void setMainid(String mainid) {
        this.mainid = mainid == null ? null : mainid.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getWaterdb() {
        return waterdb;
    }

    public void setWaterdb(String waterdb) {
        this.waterdb = waterdb == null ? null : waterdb.trim();
    }

    public String getWaterdx() {
        return waterdx;
    }

    public void setWaterdx(String waterdx) {
        this.waterdx = waterdx == null ? null : waterdx.trim();
    }

    public String getWaterzl() {
        return waterzl;
    }

    public void setWaterzl(String waterzl) {
        this.waterzl = waterzl == null ? null : waterzl.trim();
    }

    public String getWaterqt() {
        return waterqt;
    }

    public void setWaterqt(String waterqt) {
        this.waterqt = waterqt == null ? null : waterqt.trim();
    }

    public String getWaterall() {
        return waterall;
    }

    public void setWaterall(String waterall) {
        this.waterall = waterall == null ? null : waterall.trim();
    }
}