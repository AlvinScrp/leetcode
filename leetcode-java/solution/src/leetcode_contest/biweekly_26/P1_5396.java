package leetcode_contest.biweekly_26;

public class P1_5396 {

    public static void main(String[] args) {
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("abbcccddddeeeeedcba"));
        System.out.println(maxPower("triplepillooooow"));
        System.out.println(maxPower("hooraaaaaaaaaaay"));
    }

    public static int maxPower(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();

        char[] chars = s.toCharArray();
        char c = chars[0];
        int count = 1;
        int max = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == c) {
                count++;
            } else {
                c = chars[i];
                count = 1;
            }
            max = Math.max(count, max);
        }
        return max;

    }
}
