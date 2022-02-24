package others;

public class BoxBall {

    public static void main(String[] args) {

    }

    /**
     * m个盒子，每个盒子装有一定数量的球，数组nums，nums[i]表示第i个盒子中球的个数，
     * 盒子与球的单位重量均为1。 现在要将盒子装箱子，每个箱子最多容纳M个盒子，最大承重为N(单位1)，
     * 在这两个条件限制下，请问，最少需要多少个箱子？
     * 例如： m=15, nums[] ={1,1,1,2,3,3,3,3,4,4,4,5,6,6,7}, M=4, N=19
     *
     * @param m
     * @param nums
     * @param M
     * @param N
     * @return
     */
//    public int getMinCountForBoxBall(int m, int[] nums, int M, int N) {

//        int[][][] dp = new int[m + 1][M + 1][N + 1];
//
//        dp[0][0][0] = 0;
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= M; j++) {
//                for (int k = 1; k <= N; k++) {
//                    dp[i][j][k] = dp[i - 1][j - 1][k - nums[i - 1] - 1];
//
//                }
//            }
//        }
//
//        return 0;

//    }
    public int getMinCountForBoxBall(int m, int n, int[] a, int M, int N) {
        int[][] G = new int[1000][1000];

        int cntbag = 0, sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += a[i];
        }
        while (sum > 0) {
            sum = 0;
            fun(a, m, n, G);
            countminbag(a, m, n, G);
            cntbag++;
            for (int i = 1; i <= n; i++)
                sum += a[i];
            //cout<<sum<<endl;
        }

        return cntbag;
    }

    void fun(int a[], int m, int n, int[][] G) {
        int[] f = new int[1000];
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= a[i]; j--) {
                if (f[j] < f[j - a[i]] + a[i]) {
                    f[j] = f[j - a[i]] + a[i];
                    G[i][j] = 1;
                }
            }
        }
    }

    void countminbag(int a[], int m, int n, int[][] G) {
        int i = n;
        int j = m;
        while (i > 0) {
            if (G[i][j] == 1) {
                /*if不满足，表示第i件物品没装入箱子,if条件满足，表示放入箱子了*/
                //cout<<i<<endl;
                j -= a[i];//此时重量减少
                a[i] = 0;
            }
            i--;
        }
    }


}

