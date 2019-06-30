package cn.zhaolong.checking.manager.dao;


        import cn.zhaolong.checking.manager.entity.*;
        import cn.zhaolong.checking.manager.entity.Options;
        import org.apache.ibatis.annotations.*;
        import org.springframework.stereotype.Repository;


        import java.util.List;

@Mapper
@Repository
public interface Examinationmapper {
    @Select("select * from Test")
    public List<Test> getExamination();
    //抽出学生的题
    @Select("select* from test where testtype=1")
    public List<Test> getExfos();


    @Select("select * from options where testid=#{testid}")
    public List<Options> getExamOptions(int testid);
    //记录随机产生每套题
    @Insert("insert into mtest (monthid,oneque,twoque,threeque,fourque,fiveque,createdate)values" +
            "(#{mt.monthid},#{mt.oneque},#{mt.twoque},#{mt.threeque},#{mt.fourque},#{mt.fiveque},#{mt.createdate})")
    public void addmtest(@Param("mt")Mtest mt);

    //记录每个考生的考试情况
    @Insert("insert into scores (id,firstque,secondque,thirdque,fourthque,fifthque,scoress,monthid,examdate )values" +
            "(#{sc.id},#{sc.firstque},#{sc.secondque},#{sc.thirdque},#{sc.fourthque},#{sc.fifthque},#{sc.scoress},#{sc.monthid},sysdate)")
    public void addScores(@Param("sc")Scores sc);

    //显示某学生的考试记录
    @Select("select * from scores where id=#{id} order by examdate")
    public List<Scores> getScores(int id);

    //chax
    @Select("select*from mtest where monthid=#{monthid}")
    public Mtest getMTest(int monthid);

    @Select("select * from test where testid=#{testid}")
    public Test getTest1(int testid);

    @Select("select * from scores where monthid=#{monthid}")
    public Scores getScores1(int monthid);

    @Select("select * from scores where monthid=#{s.monthid} and id=#{s.id}")
    public Scores getScores2(@Param("s") Scores s);
    @Delete("delete from test where testid=#{testid}")
    public void  deleteTest(int testid);
    @Delete("delete from options where testid=#{testid}")
    public void  deleteOptiong(int testid);

    @Insert("insert into test(testid,testtype,test,testfrom)values(#{te.testid},#{te.testtype},#{te.test},#{te.testfrom})")
    public void addTest(@Param("te") Test te);

    @Insert("insert into options(testid,fouroption,judge)values(#{opt.testid},#{opt.fouroption},#{opt.judge})")
    public void addOption(@Param("opt") Options opt);


    @Select("select * from test where testid=#{testid}")
    public Test getTestByid(int testid);


    @Select("select * from options where testid=#{testid}")
    public List<Options> getOptionsByid(int testid);


    @Update("update test set test=#{te.test},testtype=#{te.testtype},testfrom=#{te.testfrom} where testid=#{te.testid}")
    public  void updateTest(@Param("te") Test te);

    @Update("update options set fouroption=#{opt.fouroption},judge=#{opt.judge} where optid=#{opt.optid}")
    public void updateOption(@Param("opt")Options opt);

    //查看教员自定义选择的一套题
    @Insert("insert into selgroupbyteacher (segroupid,monthid,selectday,teid)values(#{sgb.segroupid}," +
            "#{sgb.monthid},#{sgb.selectday},#{sgb.teid})")
    public  void addsgb(@Param("sgb") SelGroupByteacher sgb);
    @Delete("delete from selgroupbyteacher")
    public void deletesgb();

    //查看教员选定的那套题
    @Select("select *from selgroupbyteacher")
    public List<SelGroupByteacher> getsgb();

    //教员查看满意度调查表
    @Select("select * from satisfies")
    public  List<Satifies> getSatifies();
    //教员删除某个调查题
    @Delete("delete from satisfies where satifiyid=#{satifiyid}")
    public void delSatifies(int satifiyid);

    @Insert("insert into satisfies (sfhead,sftype)values(#{sf.sfhead},#{sf.sftype})")
    public  void  addSatifies(@Param("sf")Satifies sf);
    //班主任查询
    @Select("select * from test where testtype=#{testtype}")
    public  List<Test> getHeadTe(String testtype);


    //学生教师满意度试题

    @Insert("insert into sfresult(sfone,sftwo,sfthree,sffour,sffive,sfsix,sfseven,sfeight,sfnine,sften,usestate,tescores,id,gid)" +
            "values(#{sfr.sfone},#{sfr.sftwo},#{sfr.sfthree},#{sfr.sffour},#{sfr.sffive},#{sfr.sfsix}," +
            "#{sfr.sfseven},#{sfr.sfeight},#{sfr.sfnine},#{sfr.sften},#{sfr.usestate},#{sfr.tescores},#{sfr.id},#{sfr.gid})")
    public  void  addSfresult(@Param("sfr")Sfresult sfr);


    //教师查看成绩最高 最低和平均分
    @Select(" select monthid as monthid,max(scoress) as maxru,min(scoress) as minru,avg(scoress) as avgru " +
            " from SCORES s,userinfo u" +
            " where  s.id=u.id and u.gid=#{us.gid} and u.usestate=#{us.usestate}" +
            " group by s.monthid")
    public  List<TeSeeSRu> getTeSeeSRu(@Param("us") Userinfo us);


    //教师查看满意度成绩


    @Select("select * from sfresult  where gid=#{us.gid} and usestate=#{us.usestate}")
    public  List<Sfresult> getSfresult(@Param("us")Userinfo us);


    @Select("select s.id as id,scoress as scoress,chiname as chiname from scores s,userinfo u where s.id=u.id and monthid=#{monthid}")
    public List<ForStSBytechno> getFssbyte(int monthid);
}
