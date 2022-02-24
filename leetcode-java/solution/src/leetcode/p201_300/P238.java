package leetcode.p201_300;

import java.util.Arrays;

public class P238 {
    //24,12,8,6
    public static void main(String[] args) {
        new P238().productExceptSelf(new int[]{1, 2, 3, 4});
    }

//    public int[] productExceptSelf(int[] nums) {
//
//        int[] ls = new int[nums.length];
//        int[] rs = new int[nums.length];
//
//
//        for (int i = 0; i < nums.length; i++) {
//            ls[i] = i == 0 ? nums[i] : (ls[i - 1] * nums[i]);
//        }
//        for (int j = nums.length - 1; j >= 0; j--) {
//            rs[j] = j == nums.length - 1 ? nums[j] : (nums[j] * rs[j + 1]);
//        }
//        int[] res = new int[nums.length];
//        for (int k = 0; k < res.length; k++) {
//            if (k == 0) res[k] = rs[k + 1];
//            else if (k == res.length - 1) res[k] = ls[k - 1];
//            else res[k] = ls[k - 1] * rs[k + 1];
//        }
//
//        System.out.println(Arrays.toString(res));
//
//        return res;
//
//    }

    //1,2,3,4
    //24,12,8,6
    public int[] productExceptSelf(int[] nums) {

//        int[] ls = new int[nums.length];
//        int[] rs = new int[nums.length];


//        for (int i = 0; i < nums.length; i++) {
//            ls[i] = i == 0 ? nums[i] : (ls[i - 1] * nums[i]);
//        }
//        for (int j = nums.length - 1; j >= 0; j--) {
//            rs[j] = j == nums.length - 1 ? nums[j] : (nums[j] * rs[j + 1]);
//        }
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < nums.length; i++) {
            res[i] = (res[i - 1] * nums[i - 1]);
        }
//        System.out.println(Arrays.toString(res));
        for (int j = nums.length - 2; j >= 0; j--) {
            res[j] = res[j] * nums[j + 1];
            nums[j] = nums[j] * nums[j + 1];
        }

//        for (int j = nums.length - 1; j >= 0; j--) {
//            rs[j] = j == nums.length - 1 ? nums[j] : (nums[j] * rs[j + 1]);
//        }
//
//        for (int i = 0; i < res.length; i++) {
//            for (int j = 0; j < res.length; j++) {
//                if (i != j) res[j] *= nums[i];
//            }
//        }

//        for (int k = 0; k < res.length; k++) {
//
//            if (k == 0) res[k] = rs[k + 1];
//            else if (k == res.length - 1) res[k] = ls[k - 1];
//            else res[k] = ls[k - 1] * rs[k + 1];
//        }

        System.out.println(Arrays.toString(res));

        return res;

    }
}
