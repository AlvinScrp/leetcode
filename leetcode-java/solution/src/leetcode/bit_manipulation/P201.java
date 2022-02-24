package leetcode.bit_manipulation;

public class P201 {
    /**
     * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，
     * 返回此范围内所有数字的按位与（包含 m, n 两端点）。
     * 输入: [5,7] 输出: 4
     * <p>
     * 输入: [0,1] 输出: 0
     *
     * @return
     */

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
        System.out.println(rangeBitwiseAnd(1, 2));
        System.out.println(rangeBitwiseAnd(600000000, 2147483647));


    }

//    public static int rangeBitwiseAnd(int m, int n) {
//        if (n == 0) return 0;
//        if (m == n) return m;
//        long mask = 1;
//        while (n > mask) {
//            mask = mask << 1;
//        }
//        if (n == mask) return 0;
//        int mask2 = (int) (mask >> 1);
//        if (m < mask2) return 0;
//        return mask2 | (rangeBitwiseAnd(m ^ mask2, n ^ mask2));
//    }

    //    public static int rangeBitwiseAnd(int m, int n) {
//
//        if (m == n) return m;
//        int shift = 0;
//        while (n > m) {
//            n = n >> 1;
//            m = m >> 1;
//            shift++;
//        }
//        return n << shift;
//    }
    public static int rangeBitwiseAnd(int m, int n) {
        if (m == 0 || m == n) return m;
        while (n > m) {
            n = n & (n - 1);
        }
        return n;
    }
}
