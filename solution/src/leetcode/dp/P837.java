package leetcode.dp;

public class P837 {

    public static void main(String[] args) {
//        System.out.println(new P837().new21Game(10, 1, 10));
//        System.out.println(new P837().new21Game(6, 1, 10));
        System.out.println(new P837().new21Game(21, 17, 10));
//        System.out.println(new P837().new21Game(7036, 5379, 3412));


    }

    public double new21Game(int N, int K, int W) {


        if (K == 0) return 1;
        if (K - 1 + W <= N) return 1;

        double[] dp = new double[K + W];

        for (int i = K; i < K + W; i++) {
            dp[i] = i <= N ? 1.0D : 0.0D;
        }
        double w = W * 1.0D;
        double wp = (N - K + 1) * 1.0D;//后W的概率之和
        dp[K - 1] = wp / w;
        for (int i = K - 2; i >= 0; i--) {
            wp = wp + dp[i + 1] - dp[i + W + 1];
            dp[i] = wp / w;
        }
        return dp[0];

    }


    /**
     * 输入：N = 21, K = 17, W = 10
     * 输出：0.73278
     * 0 <= K <= N <= 10000
     * 1 <= W <= 10000
     * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
     *
     * @param N
     * @param K
     * @param W
     * @return
     */
//    public double new21Game(int N, int K, int W) {
//
//        if(K==0) return 1;
//        return game(0, K, N, W, new Double[K]);
//
//    }
//
//    private double game(int i, int k, int n, int w, Double[] dp) {
//
//        if (dp[i] != null) return dp[i];
//
//        int lo = i + 1, hi = i + w;
//
//        if (lo >= k) {
//            return dp[i] = caculateMoreK(lo, hi, n);
//        } else {
//            double ans = 0;
//            double moreKP = 0.0d;
//
//            if (hi >= k) {
//                moreKP = (hi - k + 1) / (w * 1.0d);
//                ans += moreKP * caculateMoreK(k, hi, n);
//                hi = k - 1;
//            }
//            double everyP = (1 - moreKP) / ((hi - lo + 1) * 1.0d);
//            for (int j = lo; j <= hi; j++) {
//                ans += everyP * game(j, k, n, w, dp);
//            }
//            return dp[i] = ans;
//        }
//
//    }
//
//    private double caculateMoreK(int lo, int hi, int n) {
//
//        if (lo > n) return 0;
//        else if (hi <= n) return 1;
//        else return (n - lo + 1) / ((hi - lo + 1) * 1.0d);
//
//    }
}
