package leetcode_contest.biweekly_74;

public class P6021 {

    public static void main(String[] args) {
        System.out.println(maximumSubsequenceCount("abdcdbc", "ac"));
        System.out.println(maximumSubsequenceCount("aabb", "ab"));
//        System.out.println(maximumSubsequenceCount("aaa", "aa"));
        System.out.println(maximumSubsequenceCount("a", "ab"));
        System.out.println(maximumSubsequenceCount("aaaabbbb", "ab"));
        System.out.println(maximumSubsequenceCount("cccccccccc", "ab"));
        System.out.println(maximumSubsequenceCount("cccccccccc", "aa"));

    }

    public static long maximumSubsequenceCount(String text, String pattern) {

        char p = pattern.charAt(0), q = pattern.charAt(1);
//        if (p == q) {
//            long num = 1;
//            for (int i = text.length() - 1; i >= 0; i--) {
//                if (text.charAt(i) == p) num++;
//            }
//            return num * (num - 1) / 2;
//        }
        int count = 0;
        long ans1 = 0, ans2 = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
            char c = text.charAt(i);
            if (c == p) {
                ans1 += (count + 1);
                ans2 += count;
            }
            if (c == q) {
                count++;
            }
        }
        ans2 += count;

        return Math.max(ans1, ans2);

    }


}
