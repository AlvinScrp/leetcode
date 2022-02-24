package leetcode.p101_200;

import java.util.Arrays;

public class P165 {

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("001"));

        compareVersion("0.1","1.1");

    }

    public static int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        System.out.println(Arrays.toString(v1));
        System.out.println(Arrays.toString(v2));
//        int i = 0, j = 0;
        for (int i = 0, j = 0; i < v1.length || j < v2.length; i++, j++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = j < v2.length ? Integer.parseInt(v2[j]) : 0;
            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
        }
        return 0;
    }
}
