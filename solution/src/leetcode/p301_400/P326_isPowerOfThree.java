package leetcode.p301_400;

public class P326_isPowerOfThree {

    public static void main(String[] args) {

    }

    public static boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;

    }
}
