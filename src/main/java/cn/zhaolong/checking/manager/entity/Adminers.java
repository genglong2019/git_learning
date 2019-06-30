package cn.zhaolong.checking.manager.entity;

public class Adminers {
    private int adminersid;
    private String adminername;
    private  String adminerpwd;

    public void setAdminersid(int adminersid) {
        this.adminersid = adminersid;
    }

    public void setAdminername(String adminername) {
        this.adminername = adminername;
    }

    public void setAdminerpwd(String adminerpwd) {
        this.adminerpwd = adminerpwd;
    }

    public int getAdminersid() {
        return adminersid;
    }

    public String getAdminername() {
        return adminername;
    }

    public String getAdminerpwd() {
        return adminerpwd;
    }
}
