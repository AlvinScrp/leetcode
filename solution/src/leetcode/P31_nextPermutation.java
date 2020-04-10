package leetcode;

public class P31_nextPermutation {
    public static void main(String[] args) {
        int[] nums1 = {3,5,8,7,6,4};
        nextPermutation(nums1);
        for (int num : nums1) {
            System.out.print(","+num);
        }
        System.out.println();
        int[] nums2 = {3,2,1};
        nextPermutation(nums2);
        for (int num : nums2) {
            System.out.print(","+num);
        }
        System.out.println();

        int[] nums3 = {1,1,5};
        nextPermutation(nums3);
        for (int num : nums3) {
            System.out.print(","+num);
        }
        System.out.println();


    }

    /**
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * <p>
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * <p>
     * 必须原地修改，只允许使用额外常数空间。
     * <p>
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     * <p>
     * 来源：力扣（LeetCode）
     *
     * 题解：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if (nums.length == 1 || nums.length == 0) {
            return;
        }
        int a = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                a = i;
                break;
            }
        }
        if (a == -1) {
            sortArrary(nums, 0, nums.length - 1);
            return;
        }
        int b = -1;
        for (int i = nums.length -1; i >= 0; i--) {
            if (nums[i] > nums[a]) {
                b = i;
                break;
            }
        }
        if (b >= 0) {
            swip(nums, a, b);
        }
        sortArrary(nums, a + 1, nums.length - 1);


    }

    public static void swip(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static void sortArrary(int[] nums, int from, int to) {

        for (int j = to; j > from; j--) {
            for (int i = from; i < j; i++) {
                if (nums[i] > nums[j]) {
                    swip(nums, i, j);
                }
            }

        }

    }
}
