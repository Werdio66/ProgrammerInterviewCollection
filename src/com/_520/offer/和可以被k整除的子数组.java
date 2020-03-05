package com._520.offer;

@SuppressWarnings("all")
public class 和可以被k整除的子数组 {

    // 挨个遍历
    public int subarraysDivByK(int[] A, int k) {

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = A[i];
            if (sum % k == 0){
                count++;
            }
            for (int j = i + 1; j < A.length; j++) {
                sum += A[j];
                if (sum % k == 0){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     *  a % 5 = 1，b % 5 = 1，则 (a - b) % 5 = 0;
     *  14 % 5 = 4, 9 % 5 = 4,则 (14 - 9) % 5 = 0;
     *
     *  所以只有余数相等，俩俩组合就是一种情况
     */
    public int subarraysDivByK1(int[] A, int k) {

        int count = 0;
        // 存储所有的余数 temp[0] = A[0], temp[1] = temp[0] + A[1]等等
        int[] temp = new int[k + 1];
        temp[0]++;

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            // 计算所有元素的和
            sum += A[i];
            // 因为和有负数，所以为了避免负数产生 (sum % k + k) % k
            // 没有负数 sum % k
            // n % 5 = {-4,-3,-2,-1,0,1,2,3,4}，则 (n % 5 + 5) % 5 = {0,1,2,3,4}。
            temp[(sum % k + k) % k]++;
        }

//        System.out.println(Arrays.toString(temp));

        for (int a : temp) {
            if (a > 1) {
                // 余数相等的组合序列，每俩个相减就是一个连续的数组和，所有只需要计算所有的俩俩组合情况
                count += a * (a - 1) / 2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 0, -2, -3, 1};
        和可以被k整除的子数组 h = new 和可以被k整除的子数组();
//        System.out.println(h.subarraysDivByK(arr, 5));
        System.out.println(h.subarraysDivByK1(arr, 5));
    }
}
