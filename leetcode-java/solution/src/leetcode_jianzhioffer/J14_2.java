package leetcode_jianzhioffer;

public class J14_2 {
    public static void main(String[] args) {
        System.out.println(new J14_2().cuttingRope(1000));//620946522
        System.out.println(new J14_2().cuttingRope(10));
//        System.out.println(new J14_2().cuttingRope(2));
//        System.out.println(new J14_2().cuttingRope(3));
    }


    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] f = new int[5];
        f[2] = 2;
        f[3] = 3;
        f[4] = 4;

        long res = 1L;
        while (n > 4) {
            n = n - 3;
            res = (res * 3) % 1000000007L;
        }
        return (int) ((res * f[n]) % 1000000007L);

    }

    private int fastPow2(int x, int y) {
        if (y == 0) return 1;
        int res = 1;
        for (; y > 0; y = y / 2) {
            if (y % 2 == 1) res = res * x;
            x = x * x;
        }
        return res;

    }
}
