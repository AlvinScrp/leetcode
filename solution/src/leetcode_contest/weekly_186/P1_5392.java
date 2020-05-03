package leetcode_contest.weekly_186;

public class P1_5392 {
    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
        System.out.println(maxScore("00111"));
        System.out.println(maxScore("1111"));
        System.out.println(maxScore("01"));
        System.out.println(maxScore("00"));

    }

    public static int maxScore(String s) {

        int count1 = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '1') {
                count1++;
            }
        }

        int maxScore = 0;
        int current0 = 0;
        int current1 = 0;
        for (int i = 0; i < length-1; i++) {
            boolean is0 = s.charAt(i) == '0';
            current0 += (is0 ? 1 : 0);
            current1 += (is0 ? 0 : 1);
            maxScore = Math.max(maxScore, current0 + (count1 - current1));
        }

        return maxScore;
    }
}
