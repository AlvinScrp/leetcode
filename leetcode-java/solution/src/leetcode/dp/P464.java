package leetcode.dp;

public class P464 {

    public static void main(String[] args) {
//        System.out.println(new P464().canIWin(4, 100));
//        System.out.println(new P464().canIWin(5, 6));
//        System.out.println(new P464().canIWin(5, 7));
//        System.out.println(new P464().canIWin(5, 8));
//        System.out.println(new P464().canIWin(5, 9));
//        System.out.println(new P464().canIWin(5, 11));
//        System.out.println(new P464().canIWin(5, 12));
//        System.out.println(new P464().canIWin(10, 40));
//        System.out.println(new P464().canIWin(20, 54));
        System.out.println(new P464().canIWin(20, 209));
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int m = maxChoosableInteger, n = desiredTotal;
        if (m * (m + 1) / 2 < n) return false;
        if (n == 0) return true;
        Boolean[] dp = new Boolean[1 << m];
        return can(m, n, 0, dp);
    }

    private boolean can(int m, int n, int chosen, Boolean[] dp) {

        if (dp[chosen] != null) return dp[chosen];
        for (int i = m; i >= 1; i--) {
            int choosing = 1 << (i - 1);
            if ((chosen & choosing) == 0) {
                if (i >= n || !can(m, n - i, chosen | choosing, dp)) {
                    return dp[chosen] = true;
                }
            }
        }
        return dp[chosen] = false;
    }
}
