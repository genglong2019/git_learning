package cn.zhaolong.checking.manager.entity;

import java.util.List;

public class TotalQuestionInfo {
    private  int monthid;
    private String test;
    private List<Options> listop;
    private String judges;

    public void setMonthid(int monthid) {
        this.monthid = monthid;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void setListop(List<Options> listop) {
        this.listop = listop;
    }

    public void setJudges(String judges) {
        this.judges = judges;
    }

    public int getMonthid() {
        return monthid;
    }

    public String getTest() {
        return test;
    }

    public List<Options> getListop() {
        return listop;
    }

    public String getJudges() {
        return judges;
    }
}
