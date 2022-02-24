package leetcode.p1_100;

public class P88_merge {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);

        for (int i = 0; i < nums1.length; i++) {
            System.out.print("," + nums1[i]);
        }
    }


//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//
//        //存放nums1中元素在新数组中的位置
//        int[] index1 = new int[m];
//        int[] index2 = new int[n];
//        for (int x = 0, i = 0, j = 0; x < m + n; x++) {
//            if (i < m && j < n) {
//                if (nums1[i] < nums2[j]) {
//                    index1[i] = x;
//                    i++;
//                } else {
//                    index2[j] = x;
//                    j++;
//                }
//            } else if (i >= m) {
//                index2[j] = x;
//                j++;
//            } else if (j >= n) {
//                index1[i] = x;
//                i++;
//            }
//        }
//        for (int i = index1.length - 1; i >= 0; i--) {
//            nums1[index1[i]] = nums1[i];
//        }
//        for (int j = index2.length - 1; j >= 0; j--) {
//            nums1[index2[j]] = nums2[j];
//        }
//
//    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }
}
