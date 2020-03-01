package com.taobao.yiwei.algorithm.dp;

/**
 * 1. 假设一个奇葩国家的钞票面额分别是1元、5元和11元，应该如何用最少的钞票数目凑出15元
 * 2. 使用面值1、5、10、20、50、100元的钞票，用最少的钞票数目凑出666元
 *
 *
 * https://www.zhihu.com/question/23995189
 *
 * 【无后效性】　　
 * 一旦f(n)确定，“我们如何凑出f(n)”就再也用不着了。　　
 * 要求出f(15)，只需要知道f(14),f(10),f(4)的值，而f(14),f(10),f(4)是如何算出来的，对之后的问题没有影响。
 * “未来与过去无关”，这就是无后效性。　　
 * （严格定义：如果给定某一阶段的状态，则在这一阶段以后过程的发展不受这阶段以前各段状态的影响。）
 *
 * 【最优子结构】　　回顾我们对f(n)的定义：我们记“凑出n所需的最少钞票数量”为f(n).　　
 * f(n)的定义就已经蕴含了“最优”。利用w=14,10,4的最优解，我们即可算出w=15的最优解。　　
 * 大问题的最优解可以由小问题的最优解推出，这个性质叫做“最优子结构性质”。　　
 *
 * 引入这两个概念之后，我们如何判断一个问题能否使用DP解决呢？　　
 * 能将大问题拆成几个小问题，且满足无后效性、最优子结构性质。
 *
 */
public class CostSample {

    public static void main(String[] args) {
        CostSample costSample = new CostSample();
        System.out.println("----- cost1 -----");
        System.out.println(costSample.cost1(15));
        System.out.println("----- cost2 -----");
        System.out.println(costSample.cost2(666));
    }

    // f(n) = min{f(n-1), f(n-5), f(n-11)} + 1, 要求出f(n)，只需要求出几个更小的f值
    private int cost1(int total) {
        int[] f = new int[total + 1];
        f[0] = 0;

        for (int i = 1; i <= total; i++) {
            int cost = Integer.MAX_VALUE;
            if (i - 1 >= 0) {
                cost = Math.min(cost, f[i - 1] + 1);
            }
            if (i - 5 >= 0) {
                cost = Math.min(cost, f[i - 5] + 1);
            }
            if (i - 11 >= 0) {
                cost = Math.min(cost, f[i - 11] + 1);
            }
            f[i] = cost;
            System.out.println("f[" + i + "]=" + f[i]);
        }
        return f[total];
    }

    private int cost2(int total) {
        int[] f = new int[total + 1];
        f[0] = 0;

        for (int i = 1; i <= total; i++) {
            int cost = Integer.MAX_VALUE;
            if (i - 1 >= 0) {
                cost = Math.min(cost, f[i - 1] + 1);
            }
            if (i - 5 >= 0) {
                cost = Math.min(cost, f[i - 5] + 1);
            }
            if (i - 10 >= 0) {
                cost = Math.min(cost, f[i - 10] + 1);
            }
            if (i - 20 >= 0) {
                cost = Math.min(cost, f[i - 20] + 1);
            }
            if (i - 50 >= 0) {
                cost = Math.min(cost, f[i - 50] + 1);
            }
            if (i - 100 >= 0) {
                cost = Math.min(cost, f[i - 100] + 1);
            }
            f[i] = cost;
//            System.out.println("f[" + i + "]=" + f[i]);
        }
        return f[total];
    }
}
