package cn.zhaolong.checking.manager.service;

import cn.zhaolong.checking.manager.entity.*;

import java.util.List;

public interface IExaminationService {
    public List<TotalExams> getExamination();

    public void addmtest(Mtest mt);

    public void addScores(Scores scores);

    public List<Scores> getScores(int id);

    public List<TotalQuestionInfo> getToQue(Scores scores);

    public Test getTest1(int testid);

    public Scores getScores1(int monthid);
    //查出所有的题和选项以及答案
    public List<TotalExams> getListExams();

    public List<Test> getTest();
    public List<Test> getAllTest();

    //删除试题
    public void deleteTest(int testid);

    public void deleteOptiong(int testid);

    public void addTest(Test te);

    public void addOption(Options opt);

    public TotalExams getUpdateQue(int testid);

    public  void updateTest( Test te);
    public void updateOption(Options opt);


    //教员自定义选择一套题
    public void addTestByTeacher(Mtest mt);

    //显示教员自定义选题的那套题
    public  void addsgb( SelGroupByteacher sgb);

    public List<TotalExams> getSelectQBym(int monthid);
    public void deletesgb();

    //教员随机5套题
    public int getRandomQ();


    public  List<Satifies> getSatifies();

    public void delSatifies(int satifiyid);

    public  void  addSatifies(Satifies sf);
//班主任
    public List<TotalExams> getHeadTe(String testtype);
    public  void HeadTeAddScores(Scores scores);


    public  void  addSfresult(Sfresult sfr);


    public  List<TeSeeSRu> getTeSeeSRu( Userinfo us);



    public  Mtest getMtests(int monthid);

    public  Sfresult getSfresult(Userinfo us);


    public List<ForStSBytechno> getFssbyte(int monthid);

}