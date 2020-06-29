package leetcode.p1_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P60 {

    public static void main(String[] args) {
        new P60().getPermutation(4, 9);
        new P60().getPermutation(3, 3);
    }

//    输入: n = 4, k = 9
//    输出: "2314"

    public String getPermutation(int n, int k) {
        int[] s = new int[n + 1];
        List<Character> nums = new ArrayList<>();

        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            s[i] = sum;
            nums.add((char) ('0' + i));
        }

        List<Character> ans = new ArrayList<>();
        for (int i = n - 1; i > 0; i--) {
            int index = (k - 1) / s[i];
            char ch = nums.remove(index);
            ans.add(ch);
            k = (k - 1) % s[i] + 1;
        }

        ans.addAll(nums);

        StringBuilder sb = new StringBuilder(n);
        for (Character an : ans) sb.append(an);
//        System.out.println(sb.toString());
        return sb.toString();
    }
}
