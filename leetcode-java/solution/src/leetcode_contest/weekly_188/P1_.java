package leetcode_contest.weekly_188;

import java.util.*;

public class P1_ {

    public static void main(String[] args) {

        System.out.println(new P1_().buildArray(new int[]{1,3},3));
    }

//    输入：target = [1,3], n = 3
//    输出：["Push","Push","Pop","Push"]
//    解释：
//    读取 1 并自动推入数组 -> [1]
//    读取 2 并自动推入数组，然后删除它 -> [1]
//    读取 3 并自动推入数组 -> [1,3]

    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        if (target == null || target.length == 0 || n == 0) return res;
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            res.add("Push");
            if (target[j] == i) {
                j++;
            } else {
                res.add("Pop");
            }
        }
        return res;

    }


}
