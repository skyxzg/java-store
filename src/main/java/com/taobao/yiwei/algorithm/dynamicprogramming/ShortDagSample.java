package com.taobao.yiwei.algorithm.dynamicprogramming;

/**
 * 给定一个城市的地图，所有的道路都是单行道，而且不会构成环。
 * 每条道路都有过路费，请问从S点到T点花费的最少费用。
 *    S —— 10 ——> A —— 30 ——> C
 *     \           \         |  \
 *      20          10      5     10
 *       _\|         _\| \|_       _\|
 *         B —— 20 -——> D —— 10 ——>  T
 */
public class ShortDagSample {
    public static void main(String[] args) {

        // 邻接矩阵
        int[][] arr = {
                { 0, 10, 20, -1, -1, -1},
                {-1,  0, -1, 30, 10, -1},
                {-1, -1,  0, -1, 20, -1},
                {-1, -1, -1,  0,  5, 10},
                {-1, -1, -1, -1,  0, 10},
                {-1, -1, -1, -1, -1,  0}
        };

        ShortDagSample sample = new ShortDagSample();
        System.out.println(sample.shortDag(arr, 5));
    }

    private int shortDag(int[][] arr, int num) {
        int[] f = new int[num + 1];
        f[0] = 0;

        for (int i = 1; i <= num; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < num; j++) {
                if (arr[j][i] == -1 || arr[j][i] == 0) {
                    continue;
                }
                min = Math.min(f[j] + arr[j][i], min);
            }
            f[i] = min;
            System.out.println("f[" + i + "]=" + min);
        }
        return f[num];
    }
}
