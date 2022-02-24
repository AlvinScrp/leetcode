package leetcode.p201_300;

import java.util.ArrayList;
import java.util.List;

public class P228 {

    public static void main(String[] args) {
        new P228().summaryRanges(new int[]{0, 1, 2, 4, 5, 7, 9});
    }

    //    输入：nums = [0,1,2,4,5,7]
//    输出：["0->2","4->5","7"]
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int j = 0, i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i] + 1 == nums[i + 1]) continue;
            if (j == i) res.add(String.valueOf(nums[j]));
            else res.add(nums[j] + "->" + nums[i]);
            j = i + 1;
        }
//        System.out.println(res);
        return res;
    }
}
