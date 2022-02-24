package leetcode.p101_200;

import java.util.Arrays;

public class P190 {

    /**
     * 输入：11111111111111111111111111111101
     * 输出：10111111111111111111111111111111
     * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
     *      因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
     * <p>
     * 输入: 00000010100101000001111010011100
     * 输出: 00111001011110000010100101000000
     * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
     *
     * @return
     */
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
        System.out.println(reverseBits(0b11111111111111111111111111111101));
    }

    public static int reverseBits(int n) {
        int[] bits = new int[32];
        Arrays.fill(bits, 0);
        for (int i = 0; n != 0 && i < 32; ) {
            bits[i++] = (n & 1) > 0 ? 1 : 0;
            n = n >>> 1;
        }
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) + bits[i];
        }
//        System.out.println(Arrays.toString(bits));
//        System.out.println(ans);

        return (int) ans;
//        return ans;
    }
}
