package com._520.offer;

/**
 * @author Werdio丶
 * @since 2020-07-22 09:38:05
 */
public class 替换空格 {

    public String replaceSpace(StringBuffer str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                stringBuilder.append("%20");
            }
            else{
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static String replaceSpace1(StringBuffer str) {
        // 用于统计空格数
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                count++;
            }
        }

        // 原字符串的长度
        int length = str.length() - 1;
        // 新字符串的长度
        int new_length = length + 2 * count;
        // 将字符串扩容，没有的元素填 \0
        str.setLength(new_length + 1);

        // 从右到左遍历字符串
        while (length >= 0 && new_length >= 0){
            // 将空格替换
            if (str.charAt(length) == ' '){
                str.setCharAt(new_length--, '0');
                str.setCharAt(new_length--, '2');
                str.setCharAt(new_length--, '%');
            }else {
                // 不是空格就直接移动
                str.setCharAt(new_length--, str.charAt(length));
            }

            // 将旧指针向前移动
            length--;
        }

        return str.toString();
    }


    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hello word ");
        System.out.println(replaceSpace1(str));
    }
}
