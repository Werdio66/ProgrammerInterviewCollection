package com._520.array;

/**
 *  字符串压缩
 *
 *  利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
 *  比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。
 *  若压缩后的字符串没有变短，则返回原先的字符串。
 */
public class ZipString {

    public String zipString(String iniString) {

        StringBuilder sb = new StringBuilder();
        int count = 1;
        char temp = iniString.charAt(0);

        for (int i = 1; i < iniString.length(); i++) {
            if (temp == iniString.charAt(i)){
                count++;
            }else {
                sb.append(temp).append(count);
                temp = iniString.charAt(i);
                count = 1;

                if (sb.length() >= iniString.length()){
                    return iniString;
                }
            }
        }

        sb.append(temp).append(count);

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new ZipString().zipString("aabcccccaaa"));
    }
}
