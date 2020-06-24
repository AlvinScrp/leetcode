package leetcode.p1_100;

import java.util.*;

public class P18_4sum {

    public static void main(String[] args) {
        int[] nums ={1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums,0));
    }

    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * 注意： 答案中不可以包含重复的四元组。
     * 示例： 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     * 满足要求的四元组集合为：
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/4sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new LinkedList<>();
        if (nums.length < 4) {
            return results;
        }
        Arrays.sort(nums);

        for (int i = 1; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {

                int left = 0;
                int right = nums.length - 1;
                while (left < i && j < right) {
                    if (nums[left] * 4 > target) {
                        break;
                    }
                    if (nums[right] * 4 < target) {
                        break;
                    }
                    int sum = nums[left] + nums[i] + nums[j] + nums[right];
                    if (sum == target) {
                        results.add(Arrays.asList(nums[left], nums[i], nums[j], nums[right]));
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }
        return new ArrayList<>(new HashSet<>(results));
    }
}
