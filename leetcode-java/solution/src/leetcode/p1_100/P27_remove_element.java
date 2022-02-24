package leetcode.p1_100;

public class P27_remove_element {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
//        System.out.println(removeDuplicates(nums));
        System.out.println(removeElement(nums, 2))  ;
    }

    /**
     * 给定 nums = [3,2,2,3], val = 3,
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     *
     * @param nums
     * @param val
     * @return
     */

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int j = nums.length - 1;
        for (int i = 0; i <= j; ) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                nums[j] = val;
                j--;
            } else {
                i++;
            }
        }
        return j+1;

    }
}

