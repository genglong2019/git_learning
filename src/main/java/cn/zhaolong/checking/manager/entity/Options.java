package cn.zhaolong.checking.manager.entity;

public class Options {
    private  int optid;
    private  int testid;
    private String fouroption;
    private  String judge;

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getJudge() {
        return judge;
    }

    public void setOptid(int optid) {
        this.optid = optid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public void setFouroption(String fouroption) {
        this.fouroption = fouroption;
    }



    public int getOptid() {
        return optid;
    }

    public int getTestid() {
        return testid;
    }

    public String getFouroption() {
        return fouroption;
    }


}
