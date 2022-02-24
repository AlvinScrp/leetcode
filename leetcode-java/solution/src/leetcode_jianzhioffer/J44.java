package leetcode_jianzhioffer;

public class J44 {
    public static void main(String[] args) {
//        System.out.println(new J44().findNthDigit(3));
//        System.out.println(new J44().findNthDigit(11));
//        System.out.println(new J44().findNthDigit(111));
//        System.out.println(new J44().findNthDigit(112));
        System.out.println(new J44().findNthDigit(1000000000));

    }

    public int findNthDigit(int n) {
        int i1 = 1;
        long i2 = 1;
        long temp = 9;

        while (n > temp) {
            n -= temp;
            i1++;
            i2 *= 10;
            temp = 9 * i1 * i2;
        }
        long ans;
        int count = n;
        //最后一个完整的数字
        long num = count / i1 + i2 - 1;
        int i = count % i1;
        if (i == 0) {
            ans = num % 10;
        } else {
            //有余数则为 num的下一个数字
            ans = Long.toString(num + 1).charAt(i - 1) - '0';
        }
        return (int) ans;
    }
}
