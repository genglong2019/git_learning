package cn.zhaolong.checking.manager.service;

import cn.zhaolong.checking.manager.dao.Examinationmapper;
import cn.zhaolong.checking.manager.entity.*;
import cn.zhaolong.checking.manager.util.MyDateUtil;
import cn.zhaolong.checking.manager.util.MyRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExaminationServiceImp implements IExaminationService {
    @Autowired
    Examinationmapper em;

   int monthids =0;
    //从题库中，随机挑选5道
    @Override
    public List<TotalExams> getExamination() {
       List<SelGroupByteacher> ls= em.getsgb();
       Mtest mt=em.getMTest(ls.get(0).getMonthid());
        int one=mt.getOneque();
        Test t1=em.getTest1(one);


        int two=mt.getTwoque();
        Test t2=em.getTest1(two);
        int three=mt.getThreeque();
        Test t3=em.getTest1(three);
        int four=mt.getFourque();
        Test t4=em.getTest1(four);
        int five=mt.getFiveque();
        Test t5=em.getTest1(five);
        List<Options> lo1=em.getExamOptions(one);
        List<Options> lo2=em.getExamOptions(two);
        List<Options> lo3=em.getExamOptions(three);
        List<Options> lo4=em.getExamOptions(four);
        List<Options> lo5=em.getExamOptions(five);
        List<TotalExams> lte=new ArrayList<TotalExams>();
        List<Integer> llt=MyRandom.randomOption();
        List<Options> l1=new ArrayList<Options>();
        for(int i=0;i<4;i++){
            l1.add(lo1.get(llt.get(i)-1));
        }
        List<Options> l2=new ArrayList<Options>();
        for(int i=0;i<4;i++){
            l2.add(lo2.get(llt.get(i)-1));
        }
        List<Options> l3=new ArrayList<Options>();
        for(int i=0;i<4;i++){
            l3.add(lo3.get(llt.get(i)-1));
        }
        List<Options> l4=new ArrayList<Options>();
        for(int i=0;i<4;i++){
            l4.add(lo4.get(llt.get(i)-1));
        }
        List<Options> l5=new ArrayList<Options>();
        for(int i=0;i<4;i++){
            l5.add(lo5.get(llt.get(i)-1));
        }
        TotalExams te1=new TotalExams();
        te1.setListop(l1);
        te1.setTestfrom(t1.getTestfrom());
        te1.setTestid(t1.getTestid());
        te1.setTest(t1.getTest());
        TotalExams te2=new TotalExams();
        te2.setListop(l2);
        te2.setTestfrom(t2.getTestfrom());
        te2.setTestid(t2.getTestid());
        te2.setTest(t2.getTest());
        TotalExams te3=new TotalExams();
        te3.setListop(l3);
        te3.setTestfrom(t3.getTestfrom());
        te3.setTestid(t3.getTestid());
        te3.setTest(t3.getTest());
        TotalExams te4=new TotalExams();
        te4.setListop(l4);
        te4.setTestfrom(t4.getTestfrom());
        te4.setTestid(t4.getTestid());
        te4.setTest(t4.getTest());
        TotalExams te5=new TotalExams();
        te5.setListop(l5);
        te5.setTestfrom(t5.getTestfrom());
        te5.setTestid(t5.getTestid());
        te5.setTest(t5.getTest());
            lte.add(te1);
        lte.add(te2);
        lte.add(te3);
        lte.add(te4);
        lte.add(te5);
        return lte;
    }


    @Override
    public void addmtest(Mtest mt) {
        em.addmtest(mt);
    }

    @Override
    public void addScores(Scores scores) {

        List<SelGroupByteacher> ls= em.getsgb();
        scores.setMonthid(ls.get(0).getMonthid());

        em.addScores(scores);
    }

    @Override
    public List<Scores> getScores(int id) {
        return em.getScores(id);
    }



    @Override
    public List<TotalQuestionInfo> getToQue(Scores scores) {
        int monthid=scores.getMonthid();
        Mtest mt=em.getMTest(monthid);

        int one=mt.getOneque();
        int two=mt.getTwoque();
        int three=mt.getThreeque();
        int four=mt.getFourque();
        int five=mt.getFiveque();
        List<Options> lo1=em.getExamOptions(one);
        List<Options> lo2=em.getExamOptions(two);
        List<Options> lo3=em.getExamOptions(three);
        List<Options> lo4=em.getExamOptions(four);
        List<Options> lo5=em.getExamOptions(five);
        List<TotalQuestionInfo> ltqlist=new ArrayList<TotalQuestionInfo>();

        String t1=em.getScores2(scores).getFirstque();
        String t2=em.getScores2(scores).getSecondque();
        String t3=em.getScores2(scores).getThirdque();
        String t4=em.getScores2(scores).getFourthque();
        String t5=em.getScores2(scores).getFifthque();

            TotalQuestionInfo tlq1=new TotalQuestionInfo();
         tlq1.setTest(getTest1(one).getTest());
         tlq1.setJudges(t1);
         tlq1.setListop(lo1);
         ltqlist.add(tlq1);
        TotalQuestionInfo tlq2=new TotalQuestionInfo();
        tlq2.setTest(getTest1(two).getTest());
        tlq2.setJudges(t2);
        tlq2.setListop(lo2);
        ltqlist.add(tlq2);
        TotalQuestionInfo tlq3=new TotalQuestionInfo();
        tlq3.setTest(getTest1(three).getTest());
        tlq3.setJudges(t3);
        tlq3.setListop(lo3);
        ltqlist.add(tlq3);
        TotalQuestionInfo tlq4=new TotalQuestionInfo();
        Test test4=getTest1(four);
        tlq4.setTest(test4.getTest());
        tlq4.setJudges(t4);
        tlq4.setListop(lo4);
        ltqlist.add(tlq4);
        TotalQuestionInfo tlq5=new TotalQuestionInfo();
        tlq5.setTest(getTest1(five).getTest());
        tlq5.setJudges(t5);
        tlq5.setListop(lo5);
        ltqlist.add(tlq5);

        return ltqlist;
    }

    @Override
    public Test getTest1(int testid) {
        return em.getTest1(testid);
    }

    @Override
    public Scores getScores1(int monthid) {
       return em.getScores1(monthid);
    }

    @Override
    public List<TotalExams> getListExams() {
        List<TotalExams> lt=new ArrayList<TotalExams>();
        List<Test> lists=em.getExamination();
        for (int i=0;i<lists.size();i++){
            Test test=lists.get(i);
            TotalExams tl=new TotalExams();
            List<Options> lists2=em.getExamOptions(test.getTestid());
            tl.setTestid(test.getTestid());
            tl.setTest(test.getTest());
            tl.setListop(lists2);
            lt.add(tl);
        }
        return lt;
    }

    @Override
    public List<Test> getTest() {
        return em.getExfos();
    }

    @Override
    public List<Test> getAllTest() {
        return em.getExamination();
    }

    @Override
    public void deleteTest(int testid) {
        em.deleteTest(testid);
    }

    @Override
    public void deleteOptiong(int testid) {
        em.deleteOptiong(testid);
    }

    @Override
    public void addTest(Test te) {
        em.addTest(te);
    }

    @Override
    public void addOption(Options opt) {
        em.addOption(opt);
    }

    @Override
    public TotalExams getUpdateQue(int testid) {
        Test te=em.getTestByid(testid);
        List<Options> lo=em.getOptionsByid(testid);
        TotalExams toe=new TotalExams();
        toe.setTest(te.getTest());
        toe.setListop(lo);
        toe.setTestid(te.getTestid());
        toe.setTestfrom(te.getTestfrom());
        return toe;
    }

    @Override
    public void updateTest(Test te) {
        em.updateTest(te);
    }

    @Override
    public void updateOption(Options opt) {
    em.updateOption(opt);
    }

    @Override
    public void addTestByTeacher(Mtest mt) {

        mt.setCreatedate(MyDateUtil.createDate());
        addmtest(mt);
    }
//自定义选题
    @Override
    public void addsgb(SelGroupByteacher sgb) {
        em.addsgb(sgb);
    }

    @Override
    public List<TotalExams> getSelectQBym(int monthid) {
        Mtest mt=em.getMTest(monthid);
        int id=2;
        int one=mt.getOneque();
        Test t1=em.getTest1(one);
        int two=mt.getTwoque();
        Test t2=em.getTest1(two);
        int three=mt.getThreeque();
        Test t3=em.getTest1(three);
        int four=mt.getFourque();
        Test t4=em.getTest1(four);
        int five=mt.getFiveque();
        Test t5=em.getTest1(five);
        List<Options> lo1=em.getExamOptions(one);
        List<Options> lo2=em.getExamOptions(two);
        List<Options> lo3=em.getExamOptions(three);
        List<Options> lo4=em.getExamOptions(four);
        List<Options> lo5=em.getExamOptions(five);
        List<TotalExams> lte=new ArrayList<TotalExams>();
        TotalExams tle1=new TotalExams();

        tle1.setTestid(one);
        tle1.setTest(t1.getTest());
        tle1.setTestfrom(t1.getTestfrom());
        tle1.setListop(lo1);
        TotalExams tle2=new TotalExams();

        tle2.setTestid(two);
        tle2.setTest(t2.getTest());
        tle2.setTestfrom(t2.getTestfrom());
        tle2.setListop(lo2);
        TotalExams tle3=new TotalExams();
        tle3.setTestid(three);
        tle3.setTest(t3.getTest());
        tle3.setTestfrom(t3.getTestfrom());
        tle3.setListop(lo3);
        TotalExams tle4=new TotalExams();
        tle4.setTestid(four);
        tle4.setTest(t4.getTest());
        tle4.setTestfrom(t4.getTestfrom());
        tle4.setListop(lo4);
        TotalExams tle5=new TotalExams();
        tle5.setTestid(five);
        tle5.setTest(t5.getTest());
        tle5.setTestfrom(t5.getTestfrom());
        tle5.setListop(lo5);
            lte.add(tle1);
        lte.add(tle2);
        lte.add(tle3);
        lte.add(tle4);
        lte.add(tle5);
        return lte;
    }

    @Override
    public void deletesgb() {
        em.deletesgb();
    }




    //挑选一套题,对4个选项随机
    @Override
    public int getRandomQ() {
        List<Test> lists=em.getExfos();
        List<Integer> sub=MyRandom.randonSubject();
        Mtest mt=new Mtest();
        Test te1= lists.get(sub.get(0)-1);
        Test te2= lists.get(sub.get(1)-1);
        Test te3= lists.get(sub.get(2)-1);
        Test te4= lists.get(sub.get(3)-1);
        Test te5= lists.get(sub.get(4)-1);
        mt.setOneque(te1.getTestid());
        mt.setTwoque(te2.getTestid());
        mt.setThreeque(te3.getTestid());
        mt.setFourque(te4.getTestid());
        mt.setFiveque(te5.getTestid());
        int n=MyRandom.getMonthid();
        mt.setMonthid(n);
        mt.setCreatedate(MyDateUtil.createDate());
        em.addmtest(mt);
            deletesgb();
        SelGroupByteacher sgb=new SelGroupByteacher();

        sgb.setFormonths(6);
        sgb.setMonthid(n);
        sgb.setTeid(2);
        sgb.setSelectday(MyDateUtil.createDate());
        sgb.setSegroupid(1);
        addsgb(sgb);
        return n;

    }

    @Override
    public List<Satifies> getSatifies() {
        return em.getSatifies();
    }

    @Override
    public void delSatifies(int satifiyid) {
        em.delSatifies(satifiyid);
    }

    @Override
    public void addSatifies(Satifies sf) {
        em.addSatifies(sf);
    }

    @Override
    public List<TotalExams> getHeadTe(String testtype) {
        List<Test> lists=em.getHeadTe(testtype);
        System.out.println(lists.get(8).getTestfrom());
        List<Integer> sub=MyRandom.randonSubject();
        List<TotalExams> lt=new ArrayList<TotalExams>();
        for (int i=0;i<5;i++){
            TotalExams te=new TotalExams();

            Test test=lists.get(sub.get(i)-1);
            int tid= test.getTestid();
            te.setTestid(tid);
            te.setTest(test.getTest());
            List<Options> lists2=em.getExamOptions(test.getTestid());
            List<Integer> opt=MyRandom.randomOption();
            List<Options> list3=new ArrayList<Options>();
            for(int j=0;j<4;j++){
                Options op= lists2.get(opt.get(j)-1);
                list3.add(op);
            }
            te.setListop(list3);
            lt.add(te);

        }
        Mtest mt=new Mtest();
        mt.setOneque(lt.get(0).getTestid());
        mt.setTwoque(lt.get(1).getTestid());
        mt.setThreeque(lt.get(2).getTestid());
        mt.setFourque(lt.get(3).getTestid());
        mt.setFiveque(lt.get(4).getTestid());
        monthids=MyRandom.getMonthid();
        mt.setMonthid(monthids);
        mt.setCreatedate(MyDateUtil.createDate());
        addmtest(mt);
        return lt;

    }
//记录班主任考试成绩
    @Override
    public void HeadTeAddScores(Scores scores) {
        scores.setMonthid(monthids);
        em.addScores(scores);
    }

    @Override
    public void addSfresult(Sfresult sfr) {
        em.addSfresult(sfr);
    }

    @Override
    public List<TeSeeSRu> getTeSeeSRu(Userinfo us) {
        return em.getTeSeeSRu(us);
    }

    @Override
    public Mtest getMtests(int monthid) {
        return em.getMTest(monthid);
    }

    @Override
    public Sfresult getSfresult(Userinfo us) {
        List<Sfresult> ls=em.getSfresult(us);
        int one=0; int two=0; int three=0; int four=0; int five=0;
        int six=0; int seven=0; int eigth=0; int nine=0; int ten=0;
        int total=0;
        for(int i=0;i<ls.size();i++){
            Sfresult sf=ls.get(i);
            one+=sf.getSfone(); two+=sf.getSftwo();three+=sf.getSfthree();four+=sf.getSffour();
            five+=sf.getSffive(); six+=sf.getSfsix();seven+=sf.getSfseven();
            eigth+=sf.getSfeight();nine+=sf.getSfnine(); ten+=sf.getSften();
            total+=sf.getTescores();
        }
        Sfresult sfs=new Sfresult();
        int num=ls.size();
        sfs.setSfone(one/num);sfs.setSftwo(two/num);sfs.setSfthree(three/num); sfs.setSffour(four/num);sfs.setSffive(five/num);
        sfs.setSfsix(six/num); sfs.setSfseven(seven/num); sfs.setSfeight(eigth/num); sfs.setSfnine(nine/num); sfs.setSften(ten/num);
        sfs.setTescores(total/num);
        return sfs;
    }

    @Override
    public List<ForStSBytechno> getFssbyte(int monthid) {
        return em.getFssbyte(monthid);
    }
}
