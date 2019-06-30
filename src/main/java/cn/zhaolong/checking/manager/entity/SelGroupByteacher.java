package cn.zhaolong.checking.manager.entity;

public class SelGroupByteacher {
    private int segroupid;
    private  int monthid;
    private  String selectday;
    private  int teid;
    private  int formonths;

    public void setSegroupid(int segroupid) {
        this.segroupid = segroupid;
    }

    public void setMonthid(int monthid) {
        this.monthid = monthid;
    }

    public void setSelectday(String selectday) {
        this.selectday = selectday;
    }

    public void setTeid(int teid) {
        this.teid = teid;
    }

    public void setFormonths(int formonths) {
        this.formonths = formonths;
    }

    public int getSegroupid() {
        return segroupid;
    }

    public int getMonthid() {
        return monthid;
    }

    public String getSelectday() {
        return selectday;
    }

    public int getTeid() {
        return teid;
    }

    public int getFormonths() {
        return formonths;
    }
}
