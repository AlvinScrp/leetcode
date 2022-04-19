package leetcode_contest.weekly_289;

public class P6070 {
    public static void main(String[] args) {
        System.out.println(new P6070().digitSum("11111222223", 3));
        System.out.println(new P6070().digitSum("00000000", 3));

    }

    public String digitSum(String s, int k) {
        if (s.length() <= k) return s;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += (s.charAt(i) - '0');
            count++;
            if (count == k) {
                sb.append(sum);
                sum = 0;
                count = 0;
            }
        }
        if (count > 0) sb.append(sum);
        return digitSum(sb.toString(), k);
    }
}
