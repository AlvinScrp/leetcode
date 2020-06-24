package leetcode.p1_100;

public class P70_climbing_stairs {


    public static void main(String[] args) {


        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        int[] f = new int[n + 1];
        if (n < 2) {
            return n;
        }
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];

    }


}
