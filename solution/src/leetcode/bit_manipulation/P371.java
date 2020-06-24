package leetcode.bit_manipulation;

public class P371 {

    /**
     * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
     * 输入: a = 1, b = 2
     * 输出: 3
     * <p>
     * 输入: a = -2, b = 3
     * 输出: 1
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        if (b == 0) return a;
        return getSum(a ^ b, (a & b) << 1);
    }
}
