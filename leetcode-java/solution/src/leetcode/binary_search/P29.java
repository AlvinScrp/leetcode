package leetcode.binary_search;

public class P29 {

    public static void main(String[] args) {
        System.out.println(new P29().divide(2147483647, 2));
        System.out.println(new P29().divide(-2147483648, 2));

    }

    public int divide(int dividend, int divisor) {
        if(divisor==dividend) return 1;
        if (divisor == 1) return dividend;
        if (divisor == -1) return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        if (divisor == Integer.MIN_VALUE) return 0;
        if (divisor == 0) return Integer.MAX_VALUE;

        int nav = ((dividend >>> 31) ^ (divisor >>> 31)) > 0 ? -1 : 1;

        divisor = Math.abs(divisor);
        int count = 0;
        if (dividend == Integer.MIN_VALUE) {
            dividend += Math.abs(divisor);
            count = 1;
        }
        dividend = Math.abs(dividend);

//        if (dividend < divisor) return nav * count;


        return nav * (count + div(dividend, divisor));

    }

    private int div(int a, int b) {
        if (a < b) return 0;

        int count = 1;
        int val = b;

        while ((a >> 1) > val) {
            count = count << 1;
            val = val << 1;
        }

        return count + div(a - val, b);
    }
}
