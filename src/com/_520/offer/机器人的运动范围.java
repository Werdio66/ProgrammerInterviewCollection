package com._520.offer;

import java.util.LinkedList;

/**
 *
 *  1、dfs
 *  2、bfs
 *
 * @author Werdio丶
 * @since 2020-09-08 15:59:05
 */
public class 机器人的运动范围 {

    int count = 0;

    public int movingCount(int threshold, int rows, int cols){
        if (threshold <= 0){
            return 0;
        }

        boolean[][] arr = new boolean[rows][cols];

        dfs(threshold, 0, 0, rows, cols, arr);

        return count;
    }

    /**
     *  1、递归函数的作用：计算最大格子数
     *  2、递归结束条件：数组边界，大于给定值，遍历过
     *  3、状态方程：每一次走的方向，上下左右
     *
     * @param threshold         给定阈值
     * @param left              当前遍历的 x 坐标
     * @param right             当前遍历 y 坐标
     * @param rows              行
     * @param cols              列
     * @param arr               表示当前行，列位置的格子是否走过
     * @return
     */
    private void dfs(int threshold, int left, int right, int rows, int cols, boolean[][] arr) {

        // 边界检查，判断当前格子是不是访问过
        if (left < 0 || left >= rows || right < 0 || right >= cols || arr[left][right]){
            return;
        }
        // 检测当前坐标值是否大于阈值
        if (check(left, right, threshold)){
            return;
        }

        // 到这里说明满足条件
        count++;
        // 更新当前位置的变量状态
        arr[left][right] = true;

        dfs(threshold, left + 1, right, rows, cols, arr);
        dfs(threshold, left, right + 1, rows, cols, arr);
        dfs(threshold, left - 1, right, rows, cols, arr);
        dfs(threshold, left, right - 1, rows, cols, arr);
    }

    /**
     *  当大于阈值返回 true
     *
     * @param left
     * @param right
     * @param threshold
     * @return
     */
    private boolean check(int left, int right, int threshold) {
        return (sum(left) + sum(right)) > threshold;
    }

    private int sum(int n) {
        int sum = 0;

        while (n > 0){
            sum += n % 10;
            n = n / 10;
        }

        return sum;
    }

    /**
     *  bfs
     *      使用队列存储结点值
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount1(int threshold, int rows, int cols){
        int count = 0;

        LinkedList<Path> queue = new LinkedList<>();
        // 标识当前位置是否访问过
        boolean[][] arr = new boolean[rows][cols];
        // 用于上下左右移动
        int[] dir = new int[]{1, 0, -1, 0, 1};
        // 存放可以访问的结点
        queue.offer(new Path(0, 0));
        arr[0][0] = true;
        while (!queue.isEmpty()){

            Path path = queue.poll();

            count++;

            for (int i = 0; i < 4; i++) {
                int x = path.x + dir[i];
                int y = path.y + dir[i + 1];

                // 保证 x，y 没有越界，且当前位置没有访问过的时候，把这个位置加入队列
                if (x >= 0 && x < rows && y >= 0 && y < cols && !arr[x][y]){
                    if (!check(x, y, threshold)){
                        queue.offer(new Path(x, y));
                        arr[x][y] = true;
                    }
                }
            }


        }

        return count;
    }


    static class Path{
        int x;
        int y;

        public Path(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        机器人的运动范围 j = new 机器人的运动范围();
        System.out.println(j.movingCount1(3, 5, 5));
    }
}
