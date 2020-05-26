package leetcode_contest.biweekly_26;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P4_5399 {

    public static void main(String[] args) {
        System.out.println(new P4_5399().largestNumber(new int[]{4, 3, 2, 5, 6, 7, 2, 5, 5}, 9));
        System.out.println(new P4_5399().largestNumber(new int[]{7, 6, 5, 5, 5, 6, 8, 7, 8}, 12));
        System.out.println( new P4_5399().largestNumber(new int[]{ 6,10,15,40,40,40,40,40,40}, 47));


    }

    //输入：cost = [4,3,2,5,6,7,2,5,5], target = 9
//输出："7772"
    public String largestNumber(int[] cost, int target) {

        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        String[] ss = new String[target + 1];
        Arrays.fill(ss, "");
        for (int i = 1; i <= target; i++) {
            int numJ = -1;
            int costJ = -1;

            for (int j = cost.length - 1; j >= 0; j--) {
                int k = i - cost[j];
                if (k >= 0 && dp[k] >= 0) {
                    int count = dp[i - cost[j]] + 1;
                    if (count > dp[i]) {
                        dp[i] = count;
                        numJ = j;
                        costJ = cost[j];
                    }
                }
            }
            if (numJ >= 0) {
                ss[i] = String.valueOf(numJ + 1) + ss[i - costJ];
            }
        }

        return ss[target] != "" ? ss[target] : "0";

    }
}
