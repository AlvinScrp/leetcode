package leetcode.p101_200;

public class P171 {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZZ"));
        System.out.println(titleToNumber("AA"));
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum * 26 + (s.charAt(i) - 'A' + 1);
        }
        return sum;
    }
}
