package leetcode.bit_manipulation;

public class P476 {
    /**
     * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
     * <p>
     * 输入: 5
     * 输出: 2
     * 解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
     * <p>
     * 输入: 1
     * 输出: 0
     * 解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
     */

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

    public static int findComplement(int num) {

        int mask = 0, temp = num;
        for (; temp > 0; ) {
            mask = (mask << 1) | 1;
            temp = (temp >> 1);
        }
//        System.out.println(Integer.toBinaryString(mask));
//        System.out.println(Integer.toBinaryString(~num));
        int ans = (~num) & mask;
        return ans;
    }
}
