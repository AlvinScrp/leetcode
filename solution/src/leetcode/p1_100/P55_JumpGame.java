package leetcode.p1_100;

public class P55_JumpGame {


    public static void main(String[] args) {


        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {0, 1};
        int[] nums4 = {0};

        System.out.println("canJump{2,3,1,1,4}:" + canJump(nums1));
        System.out.println("canJump{3,2,1,0,4}:" + canJump(nums2));
        System.out.println("canJump{0,1}:" + canJump(nums3));
        System.out.println("canJump{0}:" + canJump(nums4));
    }

    public static boolean canJump(int[] nums) {
//        if(nums.length==1){
//            return true;
//        }
        int length = nums.length;
        boolean[] f = new boolean[length];
        f[0] = true;
        for (int i = 1; i < length ; i++) {
            f[i] = false;
            for (int j = 0; j < i; j++) {
                if (f[j] && (i - j) <= nums[j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[length - 1];

    }


}
