package cn.zhaolong.checking.manager.service;


import cn.zhaolong.checking.manager.dao.Usermapper;
import cn.zhaolong.checking.manager.entity.Adminers;
import cn.zhaolong.checking.manager.entity.Options;
import cn.zhaolong.checking.manager.entity.Userinfo;
import cn.zhaolong.checking.manager.util.MyMD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserServiceImp  implements  IUserService{
    @Autowired
    Usermapper up;
    @Override
    public List<Userinfo> getUsers() {
        return up.getUser();
    }

    @Override
    public int addUserinfo(Userinfo us) {
        up.addUserinfo(us);
        return 0;
    }

    @Override
    public List<Userinfo> getUserinfoByusestate() {
        return up.getUser();
    }

    @Override
    public void delUserByid(int id) {
        up.delUserByid(id);
    }

    @Override
    public Userinfo getUserByid(int id) {
        return up.getUserByid(id);
    }

    @Override
    public void updateUserinfo(Userinfo us) {
        up.updateUserinfo(us);
    }

    @Override
    public boolean judgeLogin(Adminers adminers) {
        List<Adminers> la=up.getAdminers();

        for(int i=0;i<la.size();i++) {
            Adminers ad = la.get(i);
            if(ad.getAdminername().equals(adminers.getAdminername())){


            try {
                boolean t=  MyMD5Util.validPassword(adminers.getAdminerpwd(),ad.getAdminerpwd());
                if(t){
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
            }else{
                return false;
            }

        }
        return false;

    }

    @Override
    public void updatePwd(Adminers ad) {
        up.updatePwd(ad);
    }

    @Override
    public void updateInfobyself(Userinfo us) {
        up.updateInfobyself(us);
    }

    @Override
    public void updatePwdByU(Userinfo us) {
        up.updatePwdByU(us);
    }

    @Override
    public List<Userinfo> getUserinfoByHead(Userinfo us) {
        return up.getUserinfoByHead(us);
    }
}
