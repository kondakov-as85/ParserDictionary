package com.mycomp.ParserDictionary;


import com.mycomp.ExtUtils.StrUtils;

/**
 * Created by kondakov on 19.01.2015.
 */
public class MainClass {




    public static void main(String[] args) {
        String str = StrUtils.spaceStr("test", "+", 10, StrUtils.agCenter);
        String date = StrUtils.currentDate("dd.mm.yyyy");
        System.out.println(str);
        System.out.println(date);
    }

}
