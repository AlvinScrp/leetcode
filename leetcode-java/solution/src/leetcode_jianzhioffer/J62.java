package leetcode_jianzhioffer;

import java.util.LinkedList;

public class J62 {
    /**
     * 0,1,,n-1这n个数字排成一个圆圈，
     * 从数字0开始，每次从这个圆圈里删除第m个数字。
     * 求出这个圆圈里剩下的最后一个数字。
     * <p>
     * 例如，0、1、2、3、4这5个数字组成一个圆圈，
     * 从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     * <p>
     * 输入: n = 5, m = 3
     * 输出: 3
     * <p>
     * 输入: n = 10, m = 17
     * 输出: 2
     *
     * @return
     */


    public static void main(String[] args) {
        System.out.println(new J62().lastRemaining(5, 3));
        System.out.println(new J62().lastRemaining(10, 17));
    }

        public int lastRemaining(int n, int m) {
        if (m == 1) return n - 1;
        int f = 0;
        for (int i = 2; i <= n; i++) {
            f = (f + m) % i;
        }
        return f;
    }

}
