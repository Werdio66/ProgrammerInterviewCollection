package com._520.test;

import java.util.Scanner;

/**
 * @author Werdio丶
 * @since 2020-08-20 07:26:55
 */
public class ScannerTest {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sum = 0;
        while (s.hasNext()){


                while (s.hasNextLine()){
                    sum += s.nextInt();
                }


            System.out.println(sum);
            sum = 0;
        }


    }
}
