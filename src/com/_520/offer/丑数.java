package com._520.offer;

/**
 * @author Werdio丶
 * @since 2020-08-08 07:04:33
 */
public class 丑数 {

    public static int GetUglyNumber_Solution(int index) {

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int[] result = new int[index];
        result[0] = 1;

        for (int i = 1; i < index; i++) {
            result[i] = Math.min(result[p2] * 2, Math.min(result[p3] * 3, result[p5] * 5));
            if (result[i] == result[p2] * 2){
                p2++;
            }
            if (result[i] == result[p2] * 3){
                p3++;
            }
            if (result[i] == result[p2] * 5){
                p5++;
            }
        }
        return result[index - 1];
    }
}
