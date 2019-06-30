package cn.zhaolong.checking.manager.entity;

public class TeSeeSRu {
    private int maxru;
    private int minru;
    private int avgru;
    private int monthid;
    private String monthss;

    public void setMaxru(int maxru) {
        this.maxru = maxru;
    }

    public void setMinru(int minru) {
        this.minru = minru;
    }

    public void setAvgru(int avgru) {
        this.avgru = avgru;
    }

    public void setMonthid(int monthid) {
        this.monthid = monthid;
    }

    public void setMonthss(String monthss) {
        this.monthss = monthss;
    }

    public int getMaxru() {
        return maxru;
    }

    public int getMinru() {
        return minru;
    }

    public int getAvgru() {
        return avgru;
    }

    public int getMonthid() {
        return monthid;
    }

    public String getMonthss() {
        return monthss;
    }
}