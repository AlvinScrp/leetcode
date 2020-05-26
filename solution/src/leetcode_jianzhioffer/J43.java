package leetcode_jianzhioffer;


import java.util.HashMap;
import java.util.Map;

public class J43 {
    public static void main(String[] args) {
//        System.out.println(new J43().countDigitOne(1234));
//        System.out.println(new J43().countDigitOne(824883294));//767944060
        System.out.println(new J43().countDigitOne((int) (Math.pow(2,31)-1)));
    }

    /**
     * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
     *
     * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
     *
     *
     *
     */

    //abcde

    /**
     * c==0 ab*100  ab取(0~ab-1) de取 (0~99)
     * c==1  ab*100 + de+1      ab取(0~ab-1) de取 (0~99)    ab取ab de取(0~de)
     * c>1  ab*100  +100     c取1  ab取(0~ab) de取 (0~99)
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int count = 0;
        int i = 1;
        int c = 0, l = 0, r = 0;
        while (i <= n) {
            r = n % i;
            l = n / i / 10;
            c = (n / i) % 10;

            int inc = 0;
            if (c == 0) {
                inc = l * i;
            } else if (c == 1) {
                inc = l * i + r + 1;
            } else {
                inc = (l + 1) * i;
            }
            count += inc;
//            System.out.print("," + inc);
            if (l == 0) break;
            i *= 10;

        }
        return (int) count;
    }


}
