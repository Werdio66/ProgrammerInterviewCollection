package com._520.offer;

public class 二维数组中的查找 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        int len = matrix[0].length;

        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][len - 1] == target){
                return true;
            }else if (matrix[i][len - 1] > target){
                for (int j = 0; j < len; j++){
                    if (matrix[i][j] == target){
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
