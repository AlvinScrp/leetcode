package leetcode_contest.weekly_199;

public class P2 {

    public static void main(String[] args) {

//        System.out.println(minFlips("1010"));
//        System.out.println(minFlips("001011101"));
        System.out.println(minFlips("00000"));

    }

    public static int minFlips(String target) {
        if (target == null || target.length() == 0) return 0;

        int n = target.length();

        int start = 0;
        while (start < n&&target.charAt(start) == '0' ) start++;

        if (start == n) return 0;

        int flag = 1;
        int count = 1;
        for (int i = start; i < n; i++) {
            if (target.charAt(i) != (flag + '0')) {
                count++;
                flag = 1 - flag;
            }
        }
        return count;


    }


}
