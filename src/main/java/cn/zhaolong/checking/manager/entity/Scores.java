package cn.zhaolong.checking.manager.entity;

//存储每个人答完卷子后,答案和分数

import lombok.Data;

import java.util.Date;
@Data
public class Scores {
    private int sid;
    private int id;
    private String firstque;
    private String secondque;
    private String thirdque;
    private  String fourthque;
    private String fifthque;
    private  int scoress;
    private int monthid;
    private Date examdate;





    public void setScoress(int scoress) {
        this.scoress = scoress;
    }

    public void setMonthid(int monthid) {
        this.monthid = monthid;
    }

    public int getScoress() {
        return scoress;
    }

    public int getMonthid() {
        return monthid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstque(String firstque) {
        this.firstque = firstque;
    }

    public void setSecondque(String secondque) {
        this.secondque = secondque;
    }

    public void setThirdque(String thirdque) {
        this.thirdque = thirdque;
    }

    public void setFourthque(String fourthque) {
        this.fourthque = fourthque;
    }

    public void setFifthque(String fifthque) {
        this.fifthque = fifthque;
    }



    public int getSid() {
        return sid;
    }

    public int getId() {
        return id;
    }

    public String getFirstque() {
        return firstque;
    }

    public String getSecondque() {
        return secondque;
    }

    public String getThirdque() {
        return thirdque;
    }

    public String getFourthque() {
        return fourthque;
    }

    public String getFifthque() {
        return fifthque;
    }

}
