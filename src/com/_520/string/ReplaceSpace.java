package com._520.string;

/**
 *  替换空格
 */
public class ReplaceSpace {

    public String replaceSpace(String iniString, int length) {
        // write code here
        return iniString.replaceAll(" ", "%20");
    }

    public String replaceSpace1(String iniString, int length) {


        return "";
    }

    public static void main(String[] args) {
        String str = "hello word";
        String s = str.replaceAll(" ", "%20");
        System.out.println(s);
    }
}
