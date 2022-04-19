package leetcode_contest.weekly_289;

import java.util.Arrays;

public class P6071 {
    public static void main(String[] args) {
        System.out.println(new P6071().minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
        System.out.println(new P6071().minimumRounds(new int[]{2, 3, 3}));
    }

    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int ans = 0;
        for (int i = 0; i < tasks.length; ) {
            int j = i + 1;
            while (j < tasks.length && tasks[j] == tasks[i]) j++;
            int count = j - i;
            if (count < 2) {
                return -1;
//            } else if (count == 2 || count == 3) {
//                ans++;
            } else {
                ans += (count / 3 + (count % 3 > 0 ? 1 : 0));
            }

            i = j;
        }
        return ans;

    }
}
