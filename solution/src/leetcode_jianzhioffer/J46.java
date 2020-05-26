package leetcode_jianzhioffer;

public class J46 {
    public static void main(String[] args) {
        System.out.println(new J46().translateNum(12258));
    }

    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] += dp[i - 1];
            char pre = s.charAt(i - 2), ch = s.charAt(i - 1);
            if (pre == '1' && (ch >= '0' && ch <= '9')
                    || (pre == '2' && (ch >= '0' && ch <= '5'))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[dp.length-1];
    }
}
