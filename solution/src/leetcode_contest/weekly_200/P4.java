package leetcode_contest.weekly_200;

import java.util.ArrayList;
import java.util.List;

public class P4 {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{2,4,5,8,10},new int[]{4,6,8,9}));
    }

    public static int maxSum(int[] nums1, int[] nums2) {

        long sum1 = 0l, sum2 = 0l;
        long ans = 0l;

        int i = 0, j = 0;
        for (; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                ans = (ans + Math.max(sum1, sum2) % 1000000007) % 1000000007;
                sum1 = sum2 = nums1[i];
                i++;
                j++;
            } else {
                if (nums1[i] < nums2[j]) {
                    sum1 += nums1[i];
                    i++;
                } else {
                    sum2 += nums2[j];
                    j++;
                }
            }
        }

        for (; i < nums1.length; i++) {
            sum1 += nums1[i];
        }

        for (; j < nums2.length; j++) {
            sum2 += nums2[j];
        }

        ans = (ans + Math.max(sum1, sum2) % 1000000007) % 1000000007;

        return (int) ans;


    }
}
