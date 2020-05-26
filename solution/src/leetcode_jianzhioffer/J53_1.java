package leetcode_jianzhioffer;


public class J53_1 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] res = searchRange(nums, 0, nums.length - 1, target);
        if (res[0] == -1) return 0;
        return res[1] - res[0]+1;

    }

    private int[] searchRange(int[] nums, int l, int r, int target) {
        if (l > r) return new int[]{-1, -1};

        int mid = (r - l) / 2 + l;
        if (nums[mid] < target) {
            return searchRange(nums, mid + 1, r, target);
        } else if (nums[mid] > target) {
            return searchRange(nums, l, mid - 1, target);
        } else  {
            int[] rangeLeft = searchRange(nums, l, mid - 1, target);
            int[] rangeRight = searchRange(nums, mid + 1, r, target);
            int[] res = new int[]{-1, -1};

            res[0] = rangeLeft[0] != -1 ? rangeLeft[0] : mid;
            res[1] = rangeRight[1] != -1 ? rangeRight[1] : mid;
            return res;
        }
    }
}
