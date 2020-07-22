package com._520.offer;

/**
 *
 */
public class 二维数组中的查找 {

    public boolean Find(int[][] array, int target) {
        // 行下标
        int i = 0;
        // 列下标
        int j = array[0].length - 1;

        while (i < array.length && j >= 0){
            // 右上角的值和目标值相等
            if (array[i][j] == target){
                return true;
                // 目标值小于右上角的值
            }else if (array[i][j] > target){
                // 排除这一列
                j--;
            }else { // 目标值大于右上角的值
                // 排除这一行
                i++;
            }
        }
        return false;
    }

}
