import java.util.Arrays;

public class P4_findMedianSortedArrays {

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 3};
//        int[] nums2 = new int[]{2};

        int[] nums1 = new int[]{1, 2, 2};
        int[] nums2 = new int[]{1, 3, 4};

//        int[] nums1 = new int[]{};
//        int[] nums2 = new int[]{2};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * 示例 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * 则中位数是 2.0
     * <p>
     * 示例 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * 则中位数是 (2 + 3)/2 = 2.5
     */

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int nums2length = nums2.length;
//        int[] r = new int[nums1.length + nums2length];
//
//        int index = 0;
//        int j = 0;
//        for (int num : nums1) {
//            while (j < nums2length && num > nums2[j]) {
//                r[index] = nums2[j];
//                j++;
//                index++;
//            }
//            r[index] = num;
//            index++;
//        }
//        for (; j < nums2length; j++) {
//            r[index] = nums2[j];
//            index++;
//        }
//
//        int mi = r.length / 2;
//        return r.length % 2 == 1 ? r[mi] : (r[mi - 1] + r[mi]) / 2.0;
//    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p = 0, q = 0, r = 0;
        int result[] = new int[nums1.length + nums2.length];
        while (p < nums1.length || q < nums2.length) {
            if (p < nums1.length && q < nums2.length) {
                result[r++] = nums1[p] < nums2[q] ? nums1[p++] : nums2[q++];
            } else if (p < nums1.length) {
               System.arraycopy(nums1,p,result,r,nums1.length-p);
               break;
            } else if (q < nums2.length) {
                System.arraycopy(nums2,q,result,r,nums2.length-q);
                break;
            }
        }
        int middle = result.length / 2;
        return result.length % 2 == 1 ? result[middle] : (result[middle] + result[middle - 1]) / 2.0;
    }
}
