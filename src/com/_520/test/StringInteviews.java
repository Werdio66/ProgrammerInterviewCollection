package com._520.test;

/**
 * @author Werdio丶
 * @since 2020-07-22 16:26:32
 */
public class StringInteviews {

    public static void main(String[] args) {

        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = s3.intern();

        String s5 = "hello word";
        String s6 = "hello" + " word";

        System.out.println(s1 == s2);   // true, 因为 s1 和 s2 都指向的是字符串常量池中的数据
        System.out.println(s1 == s3);   // false, s3 指向的是堆中的对象
        /*
         *      When the intern method is invoked, if the pool already contains a
         *      string equal to this {@code String} object as determined by
         *      the {@link #equals(Object)} method, then the string from the pool is
         *      returned. Otherwise, this {@code String} object is added to the
         *      pool and a reference to this {@code String} object is returned.
         */
        System.out.println(s1 == s4);  // true, s4 是调用 intern 方法后返回的字符串，这个字符串的引用是指向常量池中的数据的，从注释中可以看到

        // true，s6 在编译的时候就将这俩个字符串拼接在了一起，发现常量池中有，就将 s6 指向常量池中的字符串
        System.out.println(s5 == s6);

        // false，底层会在堆中创建一个 Stringbuilder 对象，去 append s1 指向的字符串，
        // 然后在拼接 “ word”，然后调用 toString 方法，返回的堆中的引用
        System.out.println(s5 == s1 + " word");

    }
}
