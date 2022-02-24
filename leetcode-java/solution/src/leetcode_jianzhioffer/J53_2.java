package leetcode_jianzhioffer;

public class J53_2 {

    public static void main(String[] args) {
        new J53_2().missingNumber(new int[]{0,1,3});
    }

    public int missingNumber(int[] nums) {
        int res = biSearch(nums, 0, nums.length - 1);
        System.out.println(res);
        return res;

    }

    private int biSearch(int[] nums, int l, int r) {
        if (l > r) return l;

        int mid = (r - l) / 2 + l;

        if (nums[mid] == mid ) {
            return biSearch(nums, mid + 1, r);
        } else if (nums[mid] > mid ) {
            return biSearch(nums, l, mid - 1);
        }
        return -1;
    }
}
