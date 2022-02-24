package leetcode_contest.weekly_187;

public class P2_ {

    public static void main(String[] args) {
        System.out.println( new P2_().kLengthApart(new int[]{1,0,0,0,1,0,0,1},2));
        System.out.println( new P2_().kLengthApart(new int[]{1,0,0,1,0,1},2));
        System.out.println( new P2_().kLengthApart(new int[]{1,1,1,1,1},0));
        System.out.println( new P2_().kLengthApart(new int[]{0,1,0,1},1));
    }

    public boolean kLengthApart(int[] nums, int k) {

        int start = getStart(nums);
        if (start == -1) {
            return true;
        }

        for (int i = start + 1, j = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j++;

            } else {
                if (j < k) {
                    return false;
                }
                j = 0;
            }
        }

        return true;

    }

    public int getStart(int[] nums) {
        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                start = i;
                break;
            }
        }
        return start;
    }
}
