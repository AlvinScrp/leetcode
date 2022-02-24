package leetcode.binary_search;

public class P81 {
    public static void main(String[] args) {
        System.out.println(new P81().search(new int[]{2, 5, 6, 6, 0, 1, 2, 2}, 0));
        System.out.println(new P81().search(new int[]{3, 1,}, 3));
        System.out.println(new P81().search(new int[]{3, 1, 1}, 3));
        System.out.println(new P81().search(new int[]{3, 1, 2}, 3));
        System.out.println(new P81().search(new int[]{1, 1, 3, 1}, 3));
    }

    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private boolean search(int[] nums, int target, int lo, int hi) {

        if (lo > hi) return false;
        int mid = (hi - lo) / 2 + lo;
        if (nums[mid] == target) return true;


        if (nums[lo] < nums[mid]) {
            if (target >= nums[lo] && target < nums[mid]) {
                return search(nums, target, lo, mid - 1);
            }
        } else if (nums[mid] < nums[hi]) {
            if (target > nums[mid] && target <= nums[hi]) {
                return search(nums, target, mid + 1, hi);
            }
        }
        return search(nums, target, mid + 1, hi) || search(nums, target, lo, mid - 1);

    }
}
