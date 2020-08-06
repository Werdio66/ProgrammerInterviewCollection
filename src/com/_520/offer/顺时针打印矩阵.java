package com._520.offer;

import java.util.ArrayList;

/**
 *  输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 *  例如，如果输入如下4 X 4矩阵：
 *  1   2  3  4
 *  5   6  7  8
 *  9  10 11 12
 *  13 14 15 16
 *  则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 *  思路:
 *      顺时针打印矩阵，我们可看做是先遍历矩阵的外层，在逐渐往里遍历,通过逐渐缩小矩阵大小来完成顺时针打印
 *
 * @author Werdio丶
 * @since 2020-08-06 07:08:56
 */
public class 顺时针打印矩阵 {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        // 上边界
        int up = 0;
        // 下边界
        int down = matrix.length - 1;
        // 左边界
        int left = 0;
        // 右边界
        int right = matrix[0].length - 1;

        while (true){
            // 添加上层数据
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            // 缩小上边界
            up++;
            // 已经遍历完了
            if (up > down){
                break;
            }
            // 添加最右边的数据
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            // 缩小右边界
            right--;
            // 遍历完了
            if (left > right){
                break;
            }
            // 添加最下层数据
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            // 缩小下边界
            down--;

            if (up > down){
                break;
            }
            // 添加最左层
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            // 缩小边界
            left++;

            if (left > right){
                break;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11,12,13,14,15},
                {16, 17, 18, 19,20}
        };

        System.out.println(printMatrix(arr));
    }
}
