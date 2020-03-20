package com._520.offer;

@SuppressWarnings("all")
public class 最长回文字串 {

    /**
     *  暴力法：判断每一个字串是不是回文
     * @param s
     * @return
     */
     public String longestPalindrome(String s) {

         String max = "";
         int len = s.length();

         for (int i = 0; i < len; i++) {
             for (int j = i + 1; j <= len; j++) {
                 String str = s.substring(i, j);
                 if (max.length() < str.length() && isPalin(str)){
                     max = str;
                 }
             }

             if (len - i > max.length()){
                 return max;
             }
         }
         return max;
     }

    /**
     *  判断整个字符串是不是回文
     * @param string
     * @return
     */
     private boolean isPalin(String string){

         int left = 0;
         int right = string.length() - 1;
         while (left < right){
             if (string.charAt(left) != string.charAt(right)){
                 return false;
             }

             left++;
             right--;
         }
         return true;
     }

    /**
     *  中心扩展
     * @param s
     * @return
     */
     public String longestPalindrome1(String s) {
         String max = "";

         // 如果是偶数，在字符串中间拼接 ‘#’
         if ((s.length() & (s.length() - 1)) == 0){
             s = getStr(s);
         }

         for (int i = 1; i <= s.length(); i++) {
             int left = i - 1;
             int right = i - 1;
             while (left >= 0 && right < s.length()){
                 if (s.charAt(left) == s.charAt(right)){
                     String str = s.substring(left, right + 1);
                     max = max.length() > str.length() ? max : str;
                 }else {
                     break;
                 }
                 left--;
                 right++;
             }
         }

         return max.replaceAll("#", "");
     }

    /**
     *  将给定字符串中间加 '#'
     * @param str
     * @return
     */
     private String getStr(String str){
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < str.length(); i++) {
             sb.append("#").append(str.charAt(i));
         }
         return sb.append("# ").toString();
     }
    public static void main(String[] args) {
        最长回文字串 z = new 最长回文字串();
        String str = "abb";
        System.out.println(z.longestPalindrome1(str));
    }
}
