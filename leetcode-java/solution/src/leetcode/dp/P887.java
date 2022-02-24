package leetcode.dp;

import java.util.Arrays;

public class P887 {
    public static void main(String[] args) {
        System.out.println(new P887().superEggDrop(2, 100));
    }


    /**
     * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
     * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
     * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
     * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
     * 你的目标是确切地知道 F 的值是多少。
     * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
     *
     * @param K
     * @param N
     * @return
     */

    public int superEggDrop(int K, int N) {

        int[][] dp = new int[K + 1][N + 1];


        //如果1个鸡蛋
        for (int j = 1; j <= N; j++) {
            dp[1][j] = j;
        }

        //如果有0层楼
        for (int i = 1; i <= K; i++) {
            dp[i][0] = 0;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                int lo = 1, hi = j;
                //lo在交叉点的左侧，hi在交叉点右侧
                while (lo + 1 < hi) {
                    int mid = (hi - lo) / 2 + lo;
                    int increment = dp[i - 1][mid - 1];
                    int decrement = dp[i][j - mid];
                    if (increment == decrement) {
                        hi = lo = mid;
                    } else if (increment > decrement) {
                        hi = mid;
                    } else if (increment < decrement) {
                        lo = mid;
                    }
                }
                dp[i][j] = Math.min(count(dp, i, j, lo), count(dp, i, j, hi)) + 1;

//                int min = Integer.MAX_VALUE;
//                for (int k = 1; k <= j; k++) {
//                    min = Math.min(min, Math.max(dp[i - 1][k - 1], dp[i][j - k]) + 1);
//                }
//                dp[i][j] = min;
            }
        }
        return dp[K][N];

    }

    public static int count(int[][] dp, int i, int j, int k) {
        return Math.max(dp[i - 1][k - 1], dp[i][j - k]);
    }
}
