package cn.zhaolong.checking.manager.service;



import cn.zhaolong.checking.manager.entity.Adminers;
import cn.zhaolong.checking.manager.entity.Options;
import cn.zhaolong.checking.manager.entity.Userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserService {
    public List<Userinfo> getUsers();
    public int addUserinfo(@Param("Userinfo") Userinfo us);
    public List<Userinfo> getUserinfoByusestate();
    public  void delUserByid(int id);
    public Userinfo getUserByid(int id);
    public void updateUserinfo( Userinfo us);


    //管理员登录
    public  boolean judgeLogin(Adminers adminers);

    public  void updatePwd(Adminers ad);



    //用户完善自己的信息
    public void updateInfobyself(Userinfo us);


    //用户修改自己的密码

    public void updatePwdByU(Userinfo us);




    public  List<Userinfo> getUserinfoByHead(Userinfo us);



}
