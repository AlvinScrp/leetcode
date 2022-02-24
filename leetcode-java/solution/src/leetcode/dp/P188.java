package leetcode.dp;

public class P188 {
    public static void main(String[] args) {
        System.out.println(new P188().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        if (k > n / 2 + 1) {
            int ans = 0;
            for (int i = 1; i < n; i++) {
                ans += Math.max(0, prices[i] - prices[i - 1]);
            }
            return ans;
        }

        int m = 2 * k + 1;

        int[] pre;
        int[] cur = new int[m];


        for (int j = 0; j < m; j++) {
            cur[j] = j % 2 == 0 ? 0 : -prices[0];
        }

        for (int i = 1; i < n; i++) {
            pre = cur;
            cur[0] = 0;
            for (int j = 1; j < m; j++) {
                cur[j] = Math.max(pre[j], pre[j - 1] + (j % 2 == 0 ? prices[i] : -prices[i]));
            }
        }

        int ans = 0;
        for (int j = 0; j < m; j++) {
            if (j % 2 == 0) ans = Math.max(ans, cur[j]);
        }
        return ans;
    }
}
