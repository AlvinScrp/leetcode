package leetcode.p1_100;

public class P14_longestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));

    }

    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return strs[0];
        }

        int str1Length = strs[0].length();
        int point = 0;
        for (; point < str1Length; point++) {
            for (int i = 1; i < length; i++) {
                String str = strs[i];
                if (point >= str.length() || str.charAt(point) != strs[0].charAt(point)) {
                    return strs[0].substring(0, point);
                }
            }
        }
        return strs[0].substring(0, point);
    }
}
