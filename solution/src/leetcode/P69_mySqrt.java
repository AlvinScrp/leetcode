package leetcode;

public class P69_mySqrt {

    public static void main(String[] args) {
//        System.out.println(0<<1);

//        long time = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++) {
//            mySqrt(2147483647);
//        }
//        long time2 = System.currentTimeMillis();
//        System.out.println(time2 - time);
//
//        for (int i = 0; i < 100000; i++) {
//            mySqrt2(2147483647);
//        }
//        long time3 = System.currentTimeMillis();
//        System.out.println(time3 - time2);
//        for (int i = 0; i < 100000; i++) {
//            mySqrt3(2147483647);
//        }
//        long time4 = System.currentTimeMillis();
//        System.out.println(time4 - time3);

        System.out.println(mySqrt(2147483647));
        System.out.println(mySqrt3(2147483647));

    }

    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int temp = 0;
        for (int i = 1; i < x; i++) {
            int increment = ((i - 1) << 1) + 1;
            if (x - temp < increment) {
                return i - 1;
            } else if (x - temp == increment) {
                return i;
            }
            temp = temp + increment;


        }
        return 1;

    }


    public static int mySqrt2(int x) {
        if (x < 2) return x;

        int left = mySqrt(x >> 2) << 1;
        int right = left + 1;
        return (long) right * right > x ? left : right;
    }


    public static int mySqrt3(int x) {
        if (x < 2) return x;
        int left = 2, right = x/2;
        while (left <= right) {
            int midle = left + (right - left) / 2;
            long s = (long)midle * midle;
            if (s == x) {
                return midle;
            } else if (s > x) {
                right = midle - 1;
            } else {
                left = midle + 1;
            }

        }
        return right;


    }


}
