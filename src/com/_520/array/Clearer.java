package com._520.array;

/**
 *  清除行和列为 0 的
 *
 *  请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
 */
public class Clearer {

      public int[][] clearZero(int[][] mat, int n) {

          boolean[] raw = new boolean[n];
          boolean[] cls = new boolean[n];

          // 找到为 0 的位置
          for (int i = 0; i < n; i++) {
              for (int j = 0; j < n; j++) {
                  if (mat[i][j] == 0){
                      raw[i] = true;
                      cls[j] = true;
                  }
              }
          }

          // 只要行和列有一个为 0 ，就把整行和整列都置 0
          for (int i = 0; i < n; i++) {
              for (int j = 0; j < n; j++) {
                  if (raw[i] || cls[j]){
                      mat[i][j] = 0;
                  }
              }
          }

          return mat;
    }
}
