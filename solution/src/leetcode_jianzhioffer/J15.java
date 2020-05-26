package leetcode_jianzhioffer;

public class J15 {

    public static void main(String[] args) {

        System.out.println(hammingWeight(0b11111111111111111111111111111101));
    }

    public static int hammingWeight(int n) {
        int sum = 0;
//        if (n < 0) {
//            sum++;
//            n = n & 0b01111111111111111111111111111111;
//        }

        while (n != 0) {
            sum += 1;
            n = n & (n - 1);
        }
        return sum;

    }
}
