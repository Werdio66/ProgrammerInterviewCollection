package com._520.offer;

/**
 * @author Werdio丶
 * @since 2020-08-11 08:18:48
 */
public class 把字符串转成整数 {

    public static int StrToInt(String str) {

        int res = 1;
        int fuhao = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (i == 0 && c == '-'){
                fuhao *= -1;

            }else if (i == 0 && c == '+') {

            } else if (i == 1 && c >= 48 && c <= 57) {
                res *= (c - '0');
            } else if (i > 1 && c >= 48 && c <= 57) {
                res *= 10;
                res += (c - '0');
            }else if (i > 0){
                return 0;
            }

        }


        return res + fuhao;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("234543222"));
    }
}
