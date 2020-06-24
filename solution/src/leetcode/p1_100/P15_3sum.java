package leetcode.p1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P15_3sum {
    public static void main(String[] args) {
        int[] height = {-1, 0, 1, 2, -1, -4};
        int[] height2 = {0, 0, 0, 0};
        System.out.println(threeSum(height));
        System.out.println(threeSum(height2));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return results;
        }
        for (int i = 1; i < length; i++) {
            int left = 0, right = length - 1;
            while (left < i && i < right) {
                if (nums[left] < 0 && nums[i] < 0 && nums[right] < 0) {
                    break;
                } else if (nums[left] > 0 && nums[i] > 0 && nums[right] > 0) {
                    break;
                }else if(nums[left] == 0 && nums[i] == 0 && nums[right] == 0){
                    results.add(Arrays.asList(0,0,0));
                    break;
                }
                int sum = nums[left] + nums[i] + nums[right];
                if (sum == 0) {
                    List<Integer> result = Arrays.asList(nums[left], nums[i], nums[right]);
                    results.add(result);
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return new ArrayList<>(new HashSet<>(results));

    }
}
