package com.mycomp.ParserDictionary;


import com.mycomp.ExtUtils.StrUtils;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kondakov on 19.01.2015.
 */
public class MainClass {

    public static void main(String[] args) {
        String str = StrUtils.spaceStr("test", "+", 10, StrUtils.agCenter);
        String date = StrUtils.currentDate();
        System.out.println(str);
        System.out.println(date);

        String path = "d:\\Temp\\DALF.TXT";

        String result = "";
        BufferedReader out = null;
        try {
            out = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
            String line = null;
            while(( line = out.readLine() ) != null ) {
                int beginWord = searchBeginIndex(line);
                int endWord = searchEndIndex(line);
                if(beginWord!=-1 && endWord!=0 && endWord!=-1) {
                    if(checkWithRegExp(line)) {
                        String word = line.substring(beginWord, endWord);
                        System.out.println(word);
                    }
                }
            }
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean checkWithRegExp(String str){
        Pattern p = Pattern.compile("^\\s\\s\\s[А-Я]");
        Matcher m = p.matcher(str);
        return m.find();
    }

    private static int searchBeginIndex(String str) {
        int result = -1;
        if(!str.equals("")) {
            //Pattern p = Pattern.compile("^\\s\\s\\s[А-Я]");
            Pattern p = Pattern.compile("^\\s+");
            Matcher m = p.matcher(str);
            result = m.regionStart();
        }
        return result;
    }

    private static int searchEndIndex(String str) {
        int result = -1;
        if(!str.equals("")) {
            //Pattern p = Pattern.compile("^[^,]\\s[а-я]|[А-Я]\\s[а-я]");
            Pattern p = Pattern.compile("^\\s\\s\\s[А-Я]\\s");
            Matcher m = p.matcher(str);
            result = m.regionEnd();
        }
        return result;
    }


}
