package cn.zhaolong.checking.manager.entity;

public class AddQuestions {

    private  int testid;



    private  String whichright;
    private  String testtype;
    private String test;
    private String testfrom;
    private String firstopt;
    private String secondopt;
    private String thirdopt;
    private  String fourthopt;

    public void setWhichright(String whichright) {
        this.whichright = whichright;
    }

    public String getWhichright() {
        return whichright;
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

    public void setFirstopt(String firstopt) {
        this.firstopt = firstopt;
    }

    public void setSecondopt(String secondopt) {
        this.secondopt = secondopt;
    }

    public void setThirdopt(String thirdopt) {
        this.thirdopt = thirdopt;
    }

    public void setFourthopt(String fourthopt) {
        this.fourthopt = fourthopt;
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

    public String getFirstopt() {
        return firstopt;
    }

    public String getSecondopt() {
        return secondopt;
    }

    public String getThirdopt() {
        return thirdopt;
    }

    public String getFourthopt() {
        return fourthopt;
    }
    public void setTestid(int testid) {
        this.testid = testid;
    }

    public int getTestid() {
        return testid;
    }
}
