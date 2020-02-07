package com._520.array;

/**
 *  像素反转
 *
 *  有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，
 *  请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，
 *  将图像顺时针旋转90度。
 *
 *  1   2   3                           7   4   1
 *  4   5   5           ====>           8   5   2
 *  7   8   9                           9   5   3
 */
public class Transform {
    public int[][] transformImage(int[][] mat, int n) {

        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = mat[n - j - 1][i];
            }
        }

        return result;
    }
}