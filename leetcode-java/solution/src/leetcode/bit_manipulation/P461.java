package leetcode.bit_manipulation;

public class P461 {
    /**
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     * ↑   ↑
     * 上面的箭头指出了对应二进制位不同的位置。
     *
     * @param x
     * @param y
     * @return
     */

    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        for (; n != 0; count++) n = n & (n - 1);
        return count;

    }
}
