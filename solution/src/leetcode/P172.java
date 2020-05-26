package leetcode;

public class P172 {
    public static void main(String[] args) {
        System.out.println(new P172().trailingZeroes(3));
        System.out.println(new P172().trailingZeroes(5));
        System.out.println(new P172().trailingZeroes(15));
    }

    public int trailingZeroes(int n) {

        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;

    }
}
