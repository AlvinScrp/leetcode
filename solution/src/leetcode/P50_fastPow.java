package leetcode;

public class P50_fastPow {

    public static void main(String[] args) {
        System.out.println(myPow1(2.0000, -10));
        System.out.println(myPow2(2.0000, -10));
    }

    public static double myPow1(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return fastPow1(x, n);
//        return fastPow2(x, n);
    }

    private static double fastPow1(double x, long n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            double last = fastPow1(x, n / 2);
            return last * last;
        } else {
            return x * fastPow1(x, n - 1);
        }
    }

    public static double myPow2(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return fastPow2(x, n);
//        return fastPow2(x, n);
    }


    private static double fastPow2(double x, long n) {
        double result = 1;
        double xi = x;
        while (n >= 1) {
            if (n % 2 == 1) {
                result *= xi;
            }
            n = n / 2;
            xi = xi * xi;
        }
        return result;
    }


}
