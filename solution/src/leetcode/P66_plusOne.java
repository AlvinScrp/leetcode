package leetcode;

import java.util.Arrays;

public class P66_plusOne {

    //    public int[] plusOne(int[] digits) {
//        if (digits.length == 0) {
//            return digits;
//        }
//        int length = digits.length;
//
//        int jinwei = 1;
//        for (int i = length - 1; i >= 0; i--) {
//            int sum = digits[i] + jinwei;
//            digits[i] = sum >= 10 ? (sum - 10) : sum;
//            jinwei = sum >= 10 ? 1 : 0;
//            if (jinwei == 0) {
//                break;
//            }
//        }
//
//        if (jinwei == 0) {
//            return digits;
//        }
//        int[] res = new int[length + 1];
//        res[0] = 1;
//        for (int i = 0; i < length; i++) {
//            res[i + 1] = digits[i];
//        }
//        return res;
//    }
    public int[] plusOne2(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        int[] res = new int[length + 1];
        res[0] = 1;

        return res;
    }
}
