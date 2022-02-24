package leetcode.p101_200;

public class P191 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(0b11111111111111111111111111111101));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;

    }
}
