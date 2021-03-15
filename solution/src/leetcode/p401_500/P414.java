package leetcode.p401_500;

public class P414 {

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1,2,3,4}));
        System.out.println(thirdMax(new int[]{1,2,2,2}));
        System.out.println(thirdMax(new int[]{1,2}));

    }

    public static int thirdMax(int[] nums) {
        int max = nums[0];
        Integer max2 = null;
        Integer max3 = null;

        for (int num : nums) if (num > max) max = num;

        for (int num : nums) {
            if (num < max) {
                max2 = (max2 == null || max2 < num) ? num : max2;
            }
        }
        for (int num : nums) {
            if (num < max2) {
                max3 = (max3 == null || max3 < num) ? num : max3;
            }
        }
        return max3 != null ? max3 : max;
    }
}
