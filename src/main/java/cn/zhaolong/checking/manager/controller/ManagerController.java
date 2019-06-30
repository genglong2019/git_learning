package cn.zhaolong.checking.manager.controller;



import cn.zhaolong.checking.manager.entity.Adminers;
import cn.zhaolong.checking.manager.entity.Userinfo;
import cn.zhaolong.checking.manager.service.IUserService;
import cn.zhaolong.checking.manager.util.MyMD5Util;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("manager")
public class ManagerController {
        @Autowired
        IUserService ius;
        int id=0;
        //管理员修改用户信息方法
   @RequestMapping(value = "/updateUserInfo", method=RequestMethod.GET)
    @ResponseBody
    public String updateUserinfos( Userinfo userinfo, HttpServletResponse hsr){
        try {
        ius.updateUserinfo(userinfo);
   }catch (Exception e) {

    }
        return "";
    }
    //登录
    @RequestMapping(value = "/logins", method=RequestMethod.GET)
    @ResponseBody
    public String logins( Userinfo usrinfo,HttpServletResponse hsr){
        List<Userinfo> usrs=ius.getUsers();
        Map<String, Object> result =new HashMap<String,Object>();

        for(int i=0;i<usrs.size();i++) {
            if (usrs.get(i).getUname().equals(usrinfo.getUname())) {
                Userinfo us=usrs.get(i);
                String repwd = us.getUpwd();
                try {
                    boolean t = MyMD5Util.validPassword(usrinfo.getUpwd(), repwd);
                    if (t) {
                        id=us.getId();
                        result.put("msg",us);
                        break;
                    }else {
                        result.put("msg","1");
                        break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                result.put("msg","0");
            }
        }
        String j = JSONObject.valueToString(result);
        return j;
    }

    //显示用户信息
    @RequestMapping(value = "/showUsers", method=RequestMethod.GET)
    @ResponseBody
    public String showUsers( HttpServletResponse hsr){
        List<Userinfo> listu=ius.getUserinfoByusestate();
        Map<String, Object> result =new HashMap<String,Object>();
        result.put("books",listu);
        String j = JSONObject.valueToString(result);
        return j;
    }
    //管理员删除用户信息
    @RequestMapping(value = "/{userid}/delUserByManager", method=RequestMethod.GET)
    @ResponseBody
    public String delUser(@PathVariable()int userid,HttpServletResponse hsr){
        ius.delUserByid(userid);
        return "";
    }
    //上传图书图片
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(Userinfo usrinfo, MultipartFile mu, HttpServletRequest hr, Model model) {

        if (!mu.isEmpty()) {
            String path = hr.getSession().getServletContext()
                    .getRealPath("/resource/img");
            File file = new File(path + "/" + mu.getOriginalFilename());
            try {
                FileUtils.copyInputStreamToFile(mu.getInputStream(), file);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        model.addAttribute("file", mu.getOriginalFilename());


            Userinfo us=new Userinfo();
            us.setChiname(usrinfo.getChiname());
            us.setUimgs(mu.getOriginalFilename());
            us.setBirthday(usrinfo.getBirthday());
            us.setLocations(usrinfo.getLocations());
            us.setSex(usrinfo.getSex());
            us.setTel(usrinfo.getTel());
            us.setId(usrinfo.getId());
            ius.updateInfobyself(us);
        return "running";
    }
    @RequestMapping(value = "/{userid}/selByid", method=RequestMethod.GET)
    @ResponseBody
    public String selByid(@PathVariable()int userid,HttpServletResponse hsr){

       Userinfo us= ius.getUserByid(userid);

        Map<String, Object> result =new HashMap<String,Object>();
        result.put("users",us);
        String j = JSONObject.valueToString(result);
        return j;
    }

    @RequestMapping(value = "/mlogins", method=RequestMethod.GET)
    @ResponseBody
    public String mlogins(Adminers adminers, HttpServletResponse hsr){

        Map<String, Object> result =new HashMap<String,Object>();
        boolean t=ius.judgeLogin(adminers);

        if(t){
           result.put("msg","1");
        }else {
            result.put("msg","2");
        }
        String j = JSONObject.valueToString(result);
        return j;
    }
    //管理员修改自己密码
    @RequestMapping(value = "/updateAdmins", method=RequestMethod.GET)
    @ResponseBody
    public String  updateAdmins(Adminers adminers, HttpServletResponse hsr){

        try {
            String MDpwd= MyMD5Util.getEncryptedPwd(adminers.getAdminerpwd());
                adminers.setAdminerpwd(MDpwd);
            ius.updatePwd(adminers);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return "";
    }
    //增加新用户

    @RequestMapping(value = "/addUserInfo", method=RequestMethod.POST)
    @ResponseBody
    public String  addUserInfo(Userinfo us, HttpServletResponse hsr){
        us.setUimgs("benrentuxiang.jpg");
        String encryptedPwd = null;
        try {
            encryptedPwd = MyMD5Util.getEncryptedPwd(us.getUpwd());
            us.setUpwd(encryptedPwd);
            ius.addUserinfo(us);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    //用户修改自己密码
    @RequestMapping(value = "/updateUPwd", method=RequestMethod.GET)
    @ResponseBody
    public String  updateUPwd(Userinfo us, HttpServletResponse hsr){
        try {
            String MDpwd=MyMD5Util.getEncryptedPwd(us.getUpwd());
            us.setUpwd(MDpwd);
            ius.updatePwdByU(us);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }


    @RequestMapping(value = "/showUsersByhete", method=RequestMethod.GET)
    @ResponseBody
    public String showUsersByhete( Userinfo us,HttpServletResponse hsr){
        List<Userinfo> listss=ius.getUserinfoByHead(us);
        Map<String, Object> result =new HashMap<String,Object>();
            result.put("show1",listss);
        String j = JSONObject.valueToString(result);
        return j;
    }

}

