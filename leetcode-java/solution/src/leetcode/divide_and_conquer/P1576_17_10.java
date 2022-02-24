package leetcode.divide_and_conquer;

public class P1576_17_10 {

    public static void main(String[] args) {
        System.out.println(new P1576_17_10().majorityElement(new int[]{4, 1, 4, 2, 4, 3, 4, 3, 2, 1, 4}));
    }

    public int majorityElement(int[] nums) {

        if (nums == null || nums.length == 0) return -1;

        int count = 0, ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) ans = nums[i];
            if (nums[i] == ans) count++;
            else count--;
        }

        count = 0;
        for (int num : nums) if (ans == num) count++;
        return count > nums.length / 2 ? ans : -1;


    }
}
