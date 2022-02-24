package leetcode_contest.biweekly_25;

import java.util.Arrays;

public class P3_5386 {

    public static void main(String[] args) {
        System.out.println(checkIfCanBreak("abc","xya"));
        System.out.println(checkIfCanBreak("abe","acd"));
        System.out.println(checkIfCanBreak("leetcodee","leetcodee"));
    }

    public static boolean checkIfCanBreak(String s1, String s2) {

        int sum1 = getSum(s1);
        int sum2 = getSum(s2);

        if (sum1 < sum2) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        int[] num1=String2Array(s1);
        int[] num2=String2Array(s2);

        Arrays.sort(num1);
        Arrays.sort(num2);

        int length=num1.length;
        for (int i = 0; i < length; i++) {
            if(num1[i]<num2[i]){
                return false;
            }
        }
        return true;

    }

    private static int[] String2Array(String s) {
        int[] num=new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            num[i]=s.charAt(i)-'a';
        }
        return num;
    }

    private static int getSum(String s) {
        int sum=0;
        for (int i = 0; i < s.length(); i++) {
            sum+=(s.charAt(i)-'a');
        }
        return sum;
    }
}
