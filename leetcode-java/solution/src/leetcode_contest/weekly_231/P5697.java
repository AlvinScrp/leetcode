package leetcode_contest.weekly_231;

public class P5697 {

    public boolean checkOnesSegment(String s) {

        int count = 0;
        boolean can = true;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                if (can) {
                    count++;
                    can = false;
                }
            } else {
                can = true;
            }
        }
        return count == 1;

    }
}
