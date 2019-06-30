package cn.zhaolong.checking.manager.entity;

import java.util.List;

public class TotalExams {

    private int testid;
    private List<Options> listop;
    private String test;
    private  String testfrom;
    private int monthid;

    public void setMonthid(int monthid) {
        this.monthid = monthid;
    }

    public int getMonthid() {
        return monthid;
    }

    public void setTestfrom(String testfrom) {
        this.testfrom = testfrom;
    }

    public String getTestfrom() {
        return testfrom;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public void setListop(List<Options> listop) {
        this.listop = listop;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getTestid() {
        return testid;
    }

    public List<Options> getListop() {
        return listop;
    }

    public String getTest() {
        return test;
    }
}
