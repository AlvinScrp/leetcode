package leetcode.p1_100;

public class P34_searchRange {

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        print(searchRange(nums, 8));
        print(searchRange(nums, 6));


    }

    public static void print(int[] nums) {
        for (int index : nums) {
            System.out.print("," + index);
        }
        System.out.println();
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] indexs = {-1, -1};
        if (nums.length == 0) {
            return indexs;
        }
        indexs = binaryearch(nums, 0, nums.length - 1, target);
        return indexs;

    }

//    nums = [5,7,7,8,8,10], target = 8

    public static int[] binaryearch(int[] nums, int left, int right, int target) {
        int[] indexs = {-1, -1};
        if (left > right) {
            return indexs;
        }
        int middle = (right - left) / 2 + left;
        if (nums[middle] == target) {
            int[] results = new int[]{middle, middle};
            if (middle > left && nums[middle - 1] == nums[middle]) {
                //左侧还有
                int[] indexs2 = binaryearch(nums, left, middle - 1, target);
                if (indexs2[0] != -1) {
                    results[0] = indexs2[0];
                }
            }
            if (middle < right && nums[middle + 1] == nums[middle]) {
                // //右侧还有
                int[] indexs2 = binaryearch(nums, middle + 1, right, target);
                if (indexs2[1] != -1) {
                    results[1] = indexs2[1];
                }
            }
            return results;
        } else if (nums[middle] < target) {
            indexs = binaryearch(nums, middle + 1, right, target);

        } else {
            indexs = binaryearch(nums, left, middle - 1, target);
        }
        return indexs;

    }
}
