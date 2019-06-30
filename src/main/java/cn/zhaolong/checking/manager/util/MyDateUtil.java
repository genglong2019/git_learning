package cn.zhaolong.checking.manager.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MyDateUtil {

    public  static  String createDate(){
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM" );

    return  sdf.format(new Date());


    }

    //时间

    public static  String switchdate(Date d){

        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String d1= sdf1.format(d);
        return d1;

    }
    public static int getNextMonth(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int n=c.get(Calendar.MONTH)+1;
        return  n;
    }
}
