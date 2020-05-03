package leetcode;

public class P28_strStr {
    public static void main(String[] args) {
        System.out.println(strStr("hello","ll"));
        System.out.println(strStr("aaaaa","bba"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int index = -1;
        int hLength = haystack.length();
        int nLength = needle.length();
        for (int i = 0; i < hLength - nLength + 1; i++) {
            boolean find = true;
            for (int j = 0; j < nLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    find = false;
                    break;
                }
            }
            if (find) {
                return i;
            }
        }
        return index;

    }
}
