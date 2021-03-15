package leetcode.dp;

public class P1137 {

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
    public static int tribonacci(int n) {

        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 0, b = 1, c = 1;

        for (int i = 3; i <= n; i++) {
            int tempa = a, tempb = b, tempc = c;
            a = tempb;
            b = tempc;
            c = tempa + tempb + tempc;
        }
        return c;

    }
}
