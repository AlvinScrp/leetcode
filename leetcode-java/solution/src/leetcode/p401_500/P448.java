package leetcode.p401_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P448 {

    public static void main(String[] args) {
        new P448().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            int i = Math.abs(num) - 1;
            if (nums[i] > 0) {
                nums[i] *= -1;
            }
        }
//        System.out.println(Arrays.toString(nums));

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
