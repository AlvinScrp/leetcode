package leetcode_jianzhioffer;

public class J16 {

    public static void main(String[] args) {
        System.out.println( new J16().myPow(1.00000, -2147483648));
        System.out.println(new J16().myPow( 2.00000, 10));

    }

    public double myPow(double x, int n) {
        long y = n;
        if (y < 0) {
            x = 1 / x;
            y = -y;
        }
        return fastPow2(x, y);

    }

    private double fastPow(double x, long y) {
        if (y == 0) return 1;
        if (y == 1) return x;
        double value = fastPow(x, y / 2);
        return value * value * fastPow(x, y % 2);

    }

    private double fastPow2(double x, long y) {
        if (y == 0) return 1;
        double res = 1.0;
        for (; y > 0; y = y / 2) {
            if (y % 2 == 1) res = res * x;
            x = x * x;
        }
        return res;

    }
}
