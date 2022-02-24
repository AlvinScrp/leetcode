package leetcode.p1_100;

public class P7_ReverseInteger {
    public static void main(String[] args) {


        System.out.println(reverse(12345678));
        System.out.println(reverse(-123456789));
    }

//    private static int reverse(int x) {
//        int result = 0;
//        int temp = x;
//
//        int max = Integer.MAX_VALUE / 10;
//        int min = Integer.MIN_VALUE / 10;
//        while (temp != 0) {
//            int pop = temp % 10;
//            if (result > max || (result == max && pop > 7)) return 0;
//            if (result < min || (result == min && pop < -8)) return 0;
//            result = result * 10 + pop;
//            temp = temp / 10;
//        }
//        return result;
//    }

    private static int reverse(int x) {
        int r = 0;
        while (x != 0) {
            int pop = x % 10;
            if (r > Integer.MAX_VALUE / 10 || (r == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (r < Integer.MIN_VALUE / 10 || (r == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            r = r * 10 + pop;
            x = x / 10;
        }
        return r;
    }
}
