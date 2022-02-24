package leetcode.bit_manipulation;

public class P342 {

    /**
     * 给定一个整数 (32 位有符号整数)，
     * 请编写一个函数来判断它是否是 4 的幂次方。
     * <p>
     * 输入: 16
     * 输出: true
     * <p>
     * 输入: 5
     * 输出: false
     *
     * @return
     */
//    public static boolean isPowerOfFour(int num) {
//        return false
//                || equal(num, 1)
//                || equal(num, 1 << 2)
//                || equal(num, 1 << 4)
//                || equal(num, 1 << 6)
//                || equal(num, 1 << 8)
//                || equal(num, 1 << 10)
//                || equal(num, 1 << 12)
//                || equal(num, 1 << 14)
//                || equal(num, 1 << 16)
//                || equal(num, 1 << 18)
//                || equal(num, 1 << 20)
//                || equal(num, 1 << 22)
//                || equal(num, 1 << 24)
//                || equal(num, 1 << 26)
//                || equal(num, 1 << 28)
//                || equal(num, 1 << 30);
//
//    }
//
//    public static boolean equal(int num, int mask) {
//        return num == mask;
//    }
    public static boolean isPowerOfFour(int num) {
        return num > 0 && ((num & (num - 1)) == 0) && (num & 0xaaaaaaaa) == 0;

    }

    public static boolean equal(int num, int mask) {
        return num == mask;
    }
}
