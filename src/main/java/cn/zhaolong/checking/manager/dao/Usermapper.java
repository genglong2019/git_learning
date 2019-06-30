package cn.zhaolong.checking.manager.dao;


import cn.zhaolong.checking.manager.entity.Adminers;
import cn.zhaolong.checking.manager.entity.Options;
import cn.zhaolong.checking.manager.entity.Userinfo;
import cn.zhaolong.checking.manager.util.MyMD5Util;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Mapper
@Repository
public interface Usermapper {


 @Insert("insert into Userinfo (uname,upwd,email,usestate,uimgs,gid) values(#{us.uname},#{us.upwd},#{us.email},#{us.usestate},#{us.uimgs},#{us.gid})")
public int addUserinfo(@Param("us") Userinfo us);

    @Select("select * from Userinfo")
    public List<Userinfo> getUser();
    @Delete("delete from Userinfo where id=#{id}")
    public  void delUserByid(int id);
    @Select("select * from userinfo where id=#{id}")
    public Userinfo getUserByid(int id);
    @Update("update userinfo set gid=#{us.gid},usestate=#{us.usestate},email=#{us.email} where id=#{us.id}")
    public void updateUserinfo(@Param("us") Userinfo us);
    @Select("select*from adminers")
    public List<Adminers> getAdminers();
    @Update("update adminers set adminerpwd=#{ad.adminerpwd} where adminername=#{ad.adminername}")
    public  void updatePwd(@Param("ad")Adminers ad);
    //普通用户完善自己的信息
    @Update("update userinfo set chiname=#{us.chiname},tel=#{us.tel},sex=#{us.sex}," +
            "birthday=#{us.birthday},locations=#{us.locations},uimgs=#{us.uimgs} where id=#{us.id}")
    public void updateInfobyself(@Param("us")Userinfo us);

    //普通用户修改密码
    @Update("update userinfo set upwd=#{us.upwd} where id=#{us.id}")
    public void updatePwdByU(@Param("us")Userinfo us);

    //班主任查看自己班级学生信息
    @Select("select * from userinfo where usestate=#{us.usestate} and gid=#{us.gid}")
    public  List<Userinfo> getUserinfoByHead(@Param("us")Userinfo us);


}

