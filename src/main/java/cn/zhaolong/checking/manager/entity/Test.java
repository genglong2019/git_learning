package cn.zhaolong.checking.manager.entity;

public class Test {
    private  int testid;
    private  String testtype;
    private String test;
    private String testfrom;

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void setTestfrom(String testfrom) {
        this.testfrom = testfrom;
    }

    public int getTestid() {
        return testid;
    }

    public String getTesttype() {
        return testtype;
    }

    public String getTest() {
        return test;
    }

    public String getTestfrom() {
        return testfrom;
    }
}
