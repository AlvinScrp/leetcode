package leetcode;

public class P26_remove_duplicates_from_sorted_array {

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        System.out.println(removeDuplicates(nums));
        removeDuplicates3(nums);
        removeDuplicates4(nums);


    }

    public static int removeDuplicates1(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int dupCount = 0;
        int point = 0;

        for (int i = 1; i < nums.length - dupCount; ) {
            if (nums[i] == nums[point]) {
                for (int j = i; j < nums.length - 1 - dupCount; j++) {
                    nums[j] = nums[j + 1];
                }
                dupCount++;
            } else {
                point = i;
                i++;
            }
        }
        return nums.length - dupCount;

    }

//    public static int removeDuplicates2(int[] nums) {
//        if (nums.length < 2) {
//            return nums.length;
//        }
//        int dupCount = 0;
//        int point = 0;
//
//        for (int i = 1; i < nums.length ;  i++) {
//            if (nums[i] == nums[point]) {
//                dupCount++;
//            }
//            point = i;
//        }
//        System.out.println(dupCount);
//        return nums.length - dupCount;
//
//    }

//    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    public static int removeDuplicates3(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int dupCount = 0;
        int point = 0;

        for (int i = 1; i < nums.length ;  i++) {
            if (nums[i] != nums[point]) {
                dupCount++;
            }
        }
        System.out.println(dupCount);
        return nums.length - dupCount;

    }

    public static int removeDuplicates4(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        for (int num : nums) {
            System.out.print(","+num);
        }
        return i + 1;
    }


}
