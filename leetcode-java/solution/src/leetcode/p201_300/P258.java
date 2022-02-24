package leetcode.p201_300;

public class P258 {

    //    2147483647
//    public int addDigits(int num) {
//        int sum = num % 10
//                + num / 10 % 10
//                + num / 100 % 10
//                + num / 1000 % 10
//                + num / 10000 % 10
//                + num / 100000 % 10
//                + num / 1000000 % 10
//                + num / 10000000 % 10
//                + num / 100000000 % 10
//                + num / 1000000000 % 10;
//
//        sum = sum % 10 + sum / 10 % 10;
//        sum = sum % 10 + sum / 10 % 10;
//
//        return sum;
//
//    }
    public int addDigits(int num) {

        return (num - 1) % 9 + 1;

    }
}
