public class P9_PalindromeNumber {


    public static void main(String[] args) {


        System.out.println(isPalindrome(-123456789));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(10100));
    }

    //    public static boolean isPalindrome(int x) {
//
//        if (x < 0) {
//            return false;
//        }
//        if (x < 10) {
//            return true;
//        }
//
//        int temp=x;
//        int r = 0;
//        while (temp != 0) {
//            int pop = temp % 10;
//            if (r > Integer.MAX_VALUE / 10 || (r == Integer.MAX_VALUE / 10 && pop > 7)) return false;
//            if (r < Integer.MIN_VALUE / 10 || (r == Integer.MIN_VALUE / 10 && pop < -8)) return false;
//            r = r * 10 + pop;
//            temp = temp / 10;
//        }
//        return r == x;
//    }
    public static boolean isPalindrome(int x) {

        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reverse = 0;
        while (reverse < x) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return reverse == x || reverse / 10 == x;


    }

}
