package leetcode_jianzhioffer;

public class J14_1 {
    public static void main(String[] args) {
        System.out.println(new J14_1().cuttingRope(10));
        System.out.println(new J14_1().cuttingRope(2));
        System.out.println(new J14_1().cuttingRope(3));
    }

    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;


        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            f[i] = Math.max(f[i - 2] * 2, f[i - 3] * 3);
        }
        return f[n];

    }
}
