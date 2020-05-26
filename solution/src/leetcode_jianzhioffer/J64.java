package leetcode_jianzhioffer;

import java.util.concurrent.CyclicBarrier;

public class J64 {
    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     * @param n
     * @return
     */

    public static void main(String[] args) {
        System.out.println(new J64().sumNums(10));
    }


    public int sumNums(int n) {
        boolean b = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;

    }
}
