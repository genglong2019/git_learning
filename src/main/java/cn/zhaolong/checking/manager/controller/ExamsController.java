package cn.zhaolong.checking.manager.controller;



import cn.zhaolong.checking.manager.entity.*;

import cn.zhaolong.checking.manager.service.IExaminationService;

import cn.zhaolong.checking.manager.util.MyDateUtil;

import cn.zhaolong.checking.manager.util.MyRandom;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("exams")
public class ExamsController {
    @Autowired
    IExaminationService ies;

    @RequestMapping(value = "/createExame", method=RequestMethod.GET)
    @ResponseBody
    public String createExame( HttpServletResponse hsr){
       List<TotalExams> lt=ies.getExamination();
        Map<String, Object> result =new HashMap<String,Object>();
        result.put("doexame",lt);
        String j = JSONObject.valueToString(result);
        return j;
    }

    @RequestMapping(value = "/examlRresult", method=RequestMethod.POST)
    @ResponseBody
    public String examlRresult(Scores scores, HttpServletResponse hsr){
        ies.addScores(scores);
        Map<String, Object> result =new HashMap<String,Object>();
        String j = JSONObject.valueToString(result);
        return "";
    }
    //显示以前的考试结果
    @RequestMapping(value = "/{ss}/showExamRecond", method=RequestMethod.GET)
    @ResponseBody
    public String showExamRecond(@PathVariable()int ss, HttpServletResponse hsr){
        List<Scores> listscores=ies.getScores(ss);
        List<SDate> listsd=new ArrayList<SDate>();
        for(Scores s:listscores){
          String d= MyDateUtil.switchdate(s.getExamdate());
            SDate sd=new SDate();
            sd.setMonthid(s.getMonthid());
            sd.setScoress(s.getScoress());


            sd.setScoress(s.getScoress());
            sd.setSdateing(d);
            listsd.add(sd);
    }
        Map<String, Object> result =new HashMap<String,Object>();
        result.put("show1",listsd);
        String j = JSONObject.valueToString(result);
        return j;
    }

    //查看考题
    @RequestMapping(value = "/showquestion", method=RequestMethod.GET)
    @ResponseBody
    public String showquestions(Scores sores,HttpServletResponse hsr){
            List<TotalQuestionInfo> ltqlist=ies.getToQue(sores);
        Map<String, Object> result =new HashMap<String,Object>();
            result.put("doexame",ltqlist);
        String j = JSONObject.valueToString(result);
        return j;
    }
    //系统中查看所有试题和答案
    @RequestMapping(value = "/ShowExameByM", method=RequestMethod.GET)
    @ResponseBody
    public String ShowExameByM( HttpServletResponse hsr){
        List<TotalExams> lt=ies.getListExams();
        Map<String, Object> result =new HashMap<String,Object>();
        result.put("doexame",lt);
        String j = JSONObject.valueToString(result);
        return j;
    }
    //显示学生试题，为选题做准备
    @RequestMapping(value = "/modiyPapers", method=RequestMethod.GET)
    @ResponseBody
    public String modiyPapers( HttpServletResponse hsr){
        List<Test> listTest=ies.getTest();

        Map<String, Object> result =new HashMap<String,Object>();
        result.put("books",listTest);
        String j = JSONObject.valueToString(result);
        return j;
    }
    //显示所有的试题
    @RequestMapping(value = "/showPaperss", method=RequestMethod.GET)
    @ResponseBody
    public String showPaperss( HttpServletResponse hsr){
        List<Test> listTest=ies.getAllTest();
        Map<String, Object> result =new HashMap<String,Object>();
        result.put("books",listTest);
        String j = JSONObject.valueToString(result);
        return j;
    }
    //删除
    @RequestMapping(value = "/{userid}/delPapersByManager", method=RequestMethod.GET)
    @ResponseBody
    public String delPapersByManager(@PathVariable()int userid,HttpServletResponse hsr){
        ies.deleteOptiong(userid);
        ies.deleteTest(userid);
        return "";
    }
    @RequestMapping(value = "/addPaperInfo", method=RequestMethod.GET)
    @ResponseBody
    public String addPaperInfo(AddQuestions addq,HttpServletResponse hsr){
       Test t1=new Test();
       t1.setTest(addq.getTest());
       t1.setTestfrom(addq.getTestfrom());
       t1.setTesttype(addq.getTesttype());
       int m=MyRandom.getMonthid();
       t1.setTestid(m);
       ies.addTest(t1);
        if(addq.getWhichright().equals("1")) {
            Options opt1 = new Options();
            opt1.setTestid(m);
            opt1.setFouroption(addq.getFirstopt());
            opt1.setJudge("1");
            ies.addOption(opt1);

            Options opt2 = new Options();
            opt2.setTestid(m);
            opt2.setFouroption(addq.getSecondopt());
            opt2.setJudge("0");
            ies.addOption(opt2);

            Options opt3 = new Options();
            opt3.setTestid(m);
            opt3.setFouroption(addq.getThirdopt());
            opt3.setJudge("0");
            ies.addOption(opt3);

            Options opt4 = new Options();
            opt4.setTestid(m);
            opt4.setFouroption(addq.getFourthopt());
            opt4.setJudge("0");
            ies.addOption(opt4);
        }else if(addq.getWhichright().equals("2")){
            Options opt5 = new Options();
            opt5.setTestid(m);
            opt5.setFouroption(addq.getFirstopt());
            opt5.setJudge("0");
            ies.addOption(opt5);

            Options opt6 = new Options();
            opt6.setTestid(m);
            opt6.setFouroption(addq.getSecondopt());
            opt6.setJudge("1");
            ies.addOption(opt6);

            Options opt7 = new Options();
            opt7.setTestid(m);
            opt7.setFouroption(addq.getThirdopt());
            opt7.setJudge("0");
            ies.addOption(opt7);

            Options opt8 = new Options();
            opt8.setTestid(m);
            opt8.setFouroption(addq.getFourthopt());
            opt8.setJudge("0");
            ies.addOption(opt8);
        }else if(addq.getWhichright().equals("3")){
            Options opt9 = new Options();
            opt9.setTestid(m);
            opt9.setFouroption(addq.getFirstopt());
            opt9.setJudge("0");
            ies.addOption(opt9);

            Options opt10 = new Options();
            opt10.setTestid(m);
            opt10.setFouroption(addq.getSecondopt());
            opt10.setJudge("0");
            ies.addOption(opt9);

            Options opt11 = new Options();
            opt11.setTestid(m);
            opt11.setFouroption(addq.getThirdopt());
            opt11.setJudge("1");
            ies.addOption(opt11);

            Options opt12 = new Options();
            opt12.setTestid(m);
            opt12.setFouroption(addq.getFourthopt());
            opt12.setJudge("0");
            ies.addOption(opt12);
        }else{
            Options opt13 = new Options();
            opt13.setTestid(m);
            opt13.setFouroption(addq.getFirstopt());
            opt13.setJudge("0");
            ies.addOption(opt13);

            Options opt14 = new Options();
            opt14.setTestid(m);
            opt14.setFouroption(addq.getSecondopt());
            opt14.setJudge("0");
            ies.addOption(opt14);

            Options opt15 = new Options();
            opt15.setTestid(m);
            opt15.setFouroption(addq.getThirdopt());
            opt15.setJudge("0");
            ies.addOption(opt15);

            Options opt16 = new Options();
            opt16.setTestid(m);
            opt16.setFouroption(addq.getFourthopt());
            opt16.setJudge("1");
            ies.addOption(opt16);
        }
        return "";
    }
    int optid1=0;
    int optid2=0;
    int optid3=0;
    int optid4=0;
    //修改试题信息-回填
    @RequestMapping(value = "/{userid}/selQueByid", method=RequestMethod.GET)
    @ResponseBody
    public String selQueByid(@PathVariable()int userid,HttpServletResponse hsr){
        TotalExams tl=ies.getUpdateQue(userid);
        optid1=tl.getListop().get(0).getOptid();
        optid2=tl.getListop().get(1).getOptid();
        optid3=tl.getListop().get(2).getOptid();
        optid4=tl.getListop().get(3).getOptid();
        Map<String, Object> result =new HashMap<String,Object>();
        result.put("que",tl);
        String j = JSONObject.valueToString(result);
        return j;
    }
    @RequestMapping(value = "/updatePaperInfo", method=RequestMethod.GET)
    @ResponseBody
    public String updatePaperInfo(AddQuestions addq,HttpServletResponse hsr){
        Test t1=new Test();

        t1.setTest(addq.getTest());
        t1.setTestfrom(addq.getTestfrom());
        System.out.println(t1.getTestfrom());
        t1.setTesttype(addq.getTesttype());
        t1.setTestid(addq.getTestid());
        ies.updateTest(t1);
        if(addq.getWhichright().equals("1")) {
            Options opt1 = new Options();
            opt1.setFouroption(addq.getFirstopt());
            opt1.setJudge("1");
            opt1.setOptid(optid1);
          ies.updateOption(opt1);

            Options opt2 = new Options();
            opt2.setFouroption(addq.getSecondopt());
            opt2.setOptid(optid2);
            opt2.setJudge("0");
            ies.updateOption(opt2);

            Options opt3 = new Options();
            opt3.setFouroption(addq.getThirdopt());
            opt3.setJudge("0");
            opt3.setOptid(optid1);
            ies.updateOption(opt3);

            Options opt4 = new Options();
            opt4.setFouroption(addq.getFourthopt());
            opt4.setJudge("0");
            opt4.setOptid(optid4);
            ies.updateOption(opt4);
        }else if(addq.getWhichright().equals("2")){
            Options opt5 = new Options();

            opt5.setFouroption(addq.getFirstopt());
            opt5.setJudge("0");
            opt5.setOptid(optid1);
            ies.updateOption(opt5);

            Options opt6 = new Options();
            opt6.setFouroption(addq.getSecondopt());
            opt6.setJudge("1");
            opt6.setOptid(optid2);
            ies.updateOption(opt6);

            Options opt7 = new Options();
            opt7.setFouroption(addq.getThirdopt());
            opt7.setJudge("0");
            opt7.setOptid(optid3);
            ies.updateOption(opt7);

            Options opt8 = new Options();
            opt8.setFouroption(addq.getFourthopt());
            opt8.setJudge("0");
            opt8.setOptid(optid4);
            ies.updateOption(opt8);
        }else if(addq.getWhichright().equals("3")){
            Options opt9 = new Options();
            opt9.setFouroption(addq.getFirstopt());
            opt9.setJudge("0");
            opt9.setOptid(optid1);
            ies.updateOption(opt9);

            Options opt10 = new Options();
            opt10.setFouroption(addq.getSecondopt());
            opt10.setJudge("0");
            opt10.setOptid(optid2);
            ies.updateOption(opt10);

            Options opt11 = new Options();
            opt11.setFouroption(addq.getThirdopt());
            opt11.setJudge("1");
            opt11.setOptid(optid3);
            ies.updateOption(opt11);

            Options opt12 = new Options();
            opt12.setFouroption(addq.getFourthopt());
            opt12.setJudge("0");
            opt12.setOptid(optid4);
            ies.updateOption(opt12);
        }else{
            Options opt13 = new Options();
            opt13.setFouroption(addq.getFirstopt());
            opt13.setJudge("0");
            opt13.setOptid(optid1);
            ies.updateOption(opt13);

            Options opt14 = new Options();
            opt14.setFouroption(addq.getSecondopt());
            opt14.setJudge("0");
            opt14.setOptid(optid2);
            ies.updateOption(opt14);

            Options opt15 = new Options();
            opt15.setFouroption(addq.getThirdopt());
            opt15.setJudge("0");
            opt15.setOptid(optid3);
            ies.updateOption(opt15);

            Options opt16 = new Options();
            opt16.setFouroption(addq.getFourthopt());
            opt16.setJudge("1");
            opt16.setOptid(optid4);
            ies.updateOption(opt16);
        }
        return "";
    }

    //教员自主选题
    static int numbers=0;
   static int methodss =0;
    private Mtest mtttt=new Mtest();
    @RequestMapping(value = "/{userid}/selectGropByM", method=RequestMethod.GET)
    @ResponseBody
    public String selectGropByM(@PathVariable()int userid,HttpServletResponse hsr){


        numbers++;
        int ns=0;
        if(numbers>5){
            ns=numbers%5;
        }else{
            ns=numbers;
        }

        switch (ns){
            case 1:
                mtttt.setOneque(userid);
                break;
            case 2:
                  mtttt.setTwoque(userid);
                  break;
            case 3:
                    mtttt.setThreeque(userid);
                    break;
            case 4:
                mtttt.setFourque(userid);
                break;
            case 5:
                mtttt.setFiveque(userid);

                break;

        }
        Map<String, Object> result =new HashMap<String,Object>();
        if(ns==5){
          methodss=MyRandom.getMonthid();
          mtttt.setMonthid(methodss);
          result.put("mehtodss",mtttt);
          ies.addTestByTeacher(mtttt);
            ies.deletesgb();
            SelGroupByteacher sgb=new SelGroupByteacher();

            sgb.setFormonths(6);
            sgb.setMonthid(methodss);
            sgb.setTeid(2);
            sgb.setSelectday(MyDateUtil.createDate());
            sgb.setSegroupid(1);
            ies.addsgb(sgb);
        }else {
            result.put("methodss","no");
        }
        String j = JSONObject.valueToString(result);
        return j;
    }
    @RequestMapping(value = "/showSelcetQ", method=RequestMethod.GET)
    @ResponseBody
    public String showSelectaQ( HttpServletResponse hsr){
        List<TotalExams> lt=ies.getSelectQBym(methodss);
        Map<String, Object> result =new HashMap<String,Object>();
        result.put("doexame",lt);
        String j = JSONObject.valueToString(result);
        return j;
    }
    //显示随机产生的5道题
    @RequestMapping(value = "/showMyRandonQ", method=RequestMethod.GET)
    @ResponseBody
    public String showMyRandonQ( HttpServletResponse hsr){
        int n=ies.getRandomQ();
        List<TotalExams> lt=ies.getSelectQBym(n);
        Map<String, Object> result =new HashMap<String,Object>();
        result.put("doexame",lt);
        String j = JSONObject.valueToString(result);
        return j;
    }
    @RequestMapping(value = "/satifisy", method=RequestMethod.GET)
    @ResponseBody
    public String satifisy( HttpServletResponse hsr){
        List<Satifies> lst=ies.getSatifies();
        Map<String, Object> result =new HashMap<String,Object>();
        result.put("books",lst);
        String j = JSONObject.valueToString(result);
        return j;
    }

    @RequestMapping(value = "/{userid}/delSatifiyByManager", method=RequestMethod.GET)
    @ResponseBody
    public String delSatifiyByManager(@PathVariable()int userid,HttpServletResponse hsr){
            ies.delSatifies(userid);
        return "";
    }
    @RequestMapping(value = "/addSfInfo", method=RequestMethod.GET)
    @ResponseBody
    public String addPaperInfo(Satifies sf,HttpServletResponse hsr){
        ies.addSatifies(sf);

        return "";

    }
//班主任考试
    @RequestMapping(value = "/{testtype}/headExaming", method=RequestMethod.GET)
    @ResponseBody
    public String headExaming(@PathVariable()String testtype, HttpServletResponse hsr){
        List<TotalExams> lt=ies.getHeadTe(testtype);
        Map<String, Object> result =new HashMap<String,Object>();
        result.put("doexame",lt);
        String j = JSONObject.valueToString(result);
        return j;
    }
    @RequestMapping(value = "/headTeExamlRresult", method=RequestMethod.POST)
    @ResponseBody
    public String headTeExamlRresult(Scores scores, HttpServletResponse hsr){
        ies.HeadTeAddScores(scores);
        Map<String, Object> result =new HashMap<String,Object>();
        String j = JSONObject.valueToString(result);
        return "";
    }

    @RequestMapping(value = "/sfresult", method=RequestMethod.POST)
    @ResponseBody
    public String sfresult( Sfresult sfr,HttpServletResponse hsr){
            ies.addSfresult(sfr);
        return "";
    }

    //教师查看成绩分析
    @RequestMapping(value = "/TeSeeSRu", method=RequestMethod.GET)
    @ResponseBody
    public String TeSeeSRu( Userinfo us,HttpServletResponse hsr){

        List<TeSeeSRu> ltsr=ies.getTeSeeSRu(us);
        List<TeSeeSRu> ltsr1=new ArrayList<TeSeeSRu>();
        for(int i=0;i<ltsr.size();i++){
            TeSeeSRu tss=ltsr.get(i);
            Mtest mt=ies.getMtests(tss.getMonthid());
            tss.setMonthss(mt.getCreatedate());
            ltsr1.add(tss);
        }

        Map<String, Object> result =new HashMap<String,Object>();
        result.put("show1",ltsr1);
        String j = JSONObject.valueToString(result);
        return j;
    }


    @RequestMapping(value = "/TeSeeSfresult", method=RequestMethod.GET)
    @ResponseBody
    public String TeSeeSfresult( Userinfo us,HttpServletResponse hsr){

        Sfresult sfr=ies.getSfresult(us);
        Map<String, Object> result =new HashMap<String,Object>();
        result.put("sfr",sfr);
        String j = JSONObject.valueToString(result);
        return j;
    }




    @RequestMapping(value = "/{monthid}/forGiByTechno", method=RequestMethod.GET)
    @ResponseBody
    public String forGiByTechno( @PathVariable() int monthid,HttpServletResponse hsr){
        List<ForStSBytechno> lfssb=ies.getFssbyte(monthid);
        Map<String, Object> result =new HashMap<String,Object>();
        result.put("show1",lfssb);
        String j = JSONObject.valueToString(result);
        return j;
    }

}
