package cn.zhaolong.checking.manager.entity;

import java.util.Date;

public class Userinfo {
    private  int id;
    private  String uname;
    private  String upwd;
    private  String email;
    private  String usestate;
    private  String uimgs;
    private String gid;
    private String tel;
    private  String sex;
    private String birthday;
    private String locations;
    private String chiname;

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setChiname(String chiname) {
        this.chiname = chiname;
    }

    public String getChiname() {
        return chiname;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getTel() {
        return tel;
    }

    public String getSex() {
        return sex;
    }



    public String getLocations() {
        return locations;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGid() {
        return gid;
    }

    public void setUimgs(String uimgs) {
        this.uimgs = uimgs;
    }

    public String getUimgs() {
        return uimgs;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsestate(String usestate) {
        this.usestate = usestate;
    }

    public String getEmail() {
        return email;
    }

    public String getUsestate() {
        return usestate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public int getId() {
        return id;
    }

    public String getUname() {
        return uname;
    }

    public String getUpwd() {
        return upwd;
    }
}
