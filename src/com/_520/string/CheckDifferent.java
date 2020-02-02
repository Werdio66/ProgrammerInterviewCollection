package com._520.string;

/**
 *  确定字符互异
 *
 *  请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
 *
 * 给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。
 * 保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
 */
public class CheckDifferent {
    public boolean checkDifferent(String iniString) {

        // 1.hash 但是不能使用额外的空间，所以舍弃
        // 2.使用双重循环

        int len = iniString.length();

        // 如果字符串长度超出了 ASCII 码，只比较前 258 个即可
        if (len > 258){
            len = 259;
        }

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (iniString.charAt(i) == iniString.charAt(j)){
                    return false;
                }
            }
        }


        return true;
    }

    public static void main(String[] args) {
        String str = "acdfvbg";
        System.out.println(new CheckDifferent().checkDifferent(str));
    }
}
