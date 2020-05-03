package leetcode;

public class P67_addBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("1111", "1111"));
    }

    public static String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        int max = Math.max(m, n);
        int jinwei = 0;
        StringBuilder sb = new StringBuilder(max);

        for (int x = max - 1; x >= 0; x--) {
            int ai = intAt(a, m, x - (max - m));
            int bj = intAt(b, n, x - (max - n));
            int sum = ai + bj + jinwei;
            sb.append(sum % 2);
            jinwei = sum >= 2 ? 1 : 0;
        }
        if (jinwei == 1) {
            sb.append(jinwei);
        }
        return sb.reverse().toString();
    }

    public static int intAt(String str, int length, int index) {
        if (index >= 0 && index < length) {
            return str.charAt(index) - '0';
        }
        return 0;

    }
}
