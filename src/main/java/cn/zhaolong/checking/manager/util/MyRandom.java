package cn.zhaolong.checking.manager.util;

import java.util.ArrayList;
import java.util.List;

public class MyRandom {
    public static  List<Integer> randonSubject(){
        List<Integer> list = new ArrayList<Integer>();
        int i;
        while(list.size() < 5){
            i =(int) (Math.random() * 11);
            if(!list.contains(i)&&0!=i){
                list.add(i);
            }

        }
        return list;

    }
    public static List<Integer>randomOption(){
        List<Integer> list = new ArrayList<Integer>();
        int i;
        while(list.size() < 4){
            i = (int) (Math.random() * 5);
            if(!list.contains(i)&&0!=i){
                list.add(i);
            }

        }
        return list;

    }

    public static int getMonthid(){
        int scores1=0;
        while(scores1==0||scores1<10000000){
            scores1=(int)(Math.random() * 100000000);
        }

        return scores1;
    }
}
