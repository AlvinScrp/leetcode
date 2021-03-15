package leetcode.dp;

import java.util.Arrays;

public class P957 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7)) + ": [0,0,1,1,0,0,0,0]");
        System.out.println(Arrays.toString(prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000)) + ": [0,0,1,1,1,1,1,0]");
        System.out.println(Arrays.toString(prisonAfterNDays(new int[]{1, 1, 0, 1, 1, 0, 1, 1}, 6)) + ": [0,0,1,0,0,1,0,0]");
        System.out.println(Arrays.toString(prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 0, 1}, 826)) + ": [0,1,1,0,1,1,1,0]");
//        System.out.println(Arrays.toString(prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7)));
    }

    //    输入：cells = [1,0,0,1,0,0,1,0], N = 1000000000
//    输出：[0,0,1,1,1,1,1,0]
    public static int[] prisonAfterNDays(int[] cells, int N) {

        int[] dp = new int[256];
        int[] pre = cells;
        int[] cur = cells;

        for (int k = 1; k <= N; k++) {
            int val = 0;
            cur = new int[8];
            for (int i = 1; i < cur.length - 1; i++) {
                cur[i] = pre[i - 1] == pre[i + 1] ? 1 : 0;
                if (cur[i] == 1) val |= (1 << i);
            }

//            System.out.println(Arrays.toString(cur));

            if (dp[val] > 0) {
//                System.out.println(N + "," + (k - dp[val]));
                int mod = k - dp[val];
                if (mod == 1) break;
                if (N % mod == 0) {
                    k = N - mod + 1;
                } else {
                    k = N - N % mod + 1;
                }

                dp = new int[256];
                pre = cur;
            } else {
                pre = cur;
                dp[val] = k;
            }

        }
        return cur;

    }

}
