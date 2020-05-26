package leetcode_jianzhioffer;

import java.util.Arrays;

public class J66 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new J66().constructArr(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(new J66().constructArr(new int[]{1})));
    }

    /**
     * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
     * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
     * <p>
     * 输入: [1,2,3,4,5]
     * 输出: [120,60,40,30,24]
     *
     * @param a
     * @return
     */
//    public int[] constructArr(int[] a) {
//        int[][] dp = new int[a.length][a.length];
//        for (int i = 0; i < a.length; i++) {
//            dp[i][i] = a[i];
//            for (int j = i + 1; j < a.length; j++) {
//                dp[i][j] = dp[i][j - 1] * a[j];
//            }
//        }
//        int[] b = new int[a.length];
//        for (int i = 0; i < a.length; i++) {
//            b[i] = (i > 0 ? dp[0][i - 1] : 1) * (i + 1 < a.length ? dp[i + 1][a.length - 1] : 1);
//        }
//        return b;
//    }
    // [1,2,3,4,5]
    //120,60,40,30,24
    public int[] constructArr(int[] a) {
        if (a == null || a.length <= 1) return new int[0];
        int[] am = new int[a.length - 1];
        am[0] = a[0];
        for (int i = 1; i < a.length - 1; i++) {
            am[i] = am[i - 1] * a[i];
        }
        int[] b = new int[a.length];
        int bm = 1;
        for (int j = a.length - 1; j >= 0; j--) {
            b[j] = (j == 0 ? 1 : am[j - 1]) * bm;
            bm *= a[j];
        }
        return b;
    }
}
