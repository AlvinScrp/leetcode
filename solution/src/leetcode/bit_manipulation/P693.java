package leetcode.bit_manipulation;

public class P693 {
    public static void main(String[] args) {
        System.out.println(new P693().hasAlternatingBits(5));
        System.out.println(new P693().hasAlternatingBits(7));
        System.out.println(new P693().hasAlternatingBits(11));
        System.out.println(new P693().hasAlternatingBits(10));
        System.out.println(new P693().hasAlternatingBits(4));
    }

    public boolean hasAlternatingBits(int n) {
        int a = n ^ (n >> 1);
        return ((a + 1) & a) == 0;
    }
}
