package leetcode_fuxi20201208;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P93 {
    public static void main(String[] args) {
        System.out.println(new P93().restoreIpAddresses("25525511135"));
        System.out.println(new P93().restoreIpAddresses("0000"));
    }

    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        LinkedList<Integer> nums = new LinkedList<>();
        dfs(s, nums, res);
        return res;
    }

    public void dfs(String s, LinkedList<Integer> nums, List<String> res) {

        if (nums.size() == 4) {
            if (s.length() == 0) {
                StringBuilder sb = new StringBuilder();
                for (Integer num : nums) sb.append("." + num);
                res.add(sb.toString().substring(1));
            }
            return;
        }
//        25525511135
        if (s.startsWith("0")) {
            nums.add(0);
            dfs(s.substring(1), nums, res);
            nums.removeLast();
            return;
        }
        for (int i = 1; i <= s.length() && i <= 3; i++) {
            Integer num = Integer.parseInt(s.substring(0, i));
            if (num <= 255) {
                nums.add(num);
                dfs(s.substring(i), nums, res);
                nums.removeLast();
            }
        }
    }
}
