package leetcode_fuxi20201208;

import java.util.Arrays;

public class P912 {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 2, 4, 3, 6};
//        int[] nums = new int[]{5, 4, 3, 2, 1, 0};
//        int[] nums = new int[]{2, 3, 1};
        System.out.println(Arrays.toString(nums));
        System.out.println("----------------------------");
        System.out.println(Arrays.toString(new P912().bubbleSort(Arrays.copyOf(nums, nums.length))));
        System.out.println(Arrays.toString(new P912().selectSort(Arrays.copyOf(nums, nums.length))));
        System.out.println(Arrays.toString(new P912().insertionSort(Arrays.copyOf(nums, nums.length))));
        System.out.println(Arrays.toString(new P912().mergeSort(Arrays.copyOf(nums, nums.length))));
//        System.out.println(Arrays.toString(new P912().quickSort1(Arrays.copyOf(nums, nums.length))));
//        System.out.println(Arrays.toString(new P912().quickSort2(Arrays.copyOf(nums, nums.length))));
//        System.out.println(Arrays.toString(new P912().heapSort(Arrays.copyOf(nums, nums.length))));

    }


    /**
     * （无序区，有序区）。
     * 从无序区透过交换找出最大元素放到有序区前端。
     *
     * @param nums
     * @return
     */
    public int[] bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) swap(nums, j, j + 1);
            }
        }
        return nums;
    }

    /**
     * （有序区，无序区）。
     * 在无序区里找一个最小的元素跟在有序区的后面。对数组：比较得多，换得少。
     *
     * @param nums
     * @return
     */
    public int[] selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[k]) k = j;
            }
            if (k != i) swap(nums, i, k);
        }
        return nums;
    }


    /**
     * 有序区，无序区）。
     * 把无序区的第一个元素插入到有序区的合适的位置。对数组：比较得少，换得多。
     */
    public int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) swap(nums, j, j - 1);
            }
        }
        return nums;

    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public int[] mergeSort(int[] nums) {
        divAndMerge(nums, 0, nums.length - 1);
        return nums;
    }

    private void divAndMerge(int[] nums, int start, int end) {

        if (end <= start) return;
        int mid = (end - start) / 2 + start;

        divAndMerge(nums, start, mid);
        divAndMerge(nums, mid + 1, end);
        merge(nums, start, mid, end);

    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] array = Arrays.copyOf(nums, nums.length);
        for (int i = start, j = mid + 1, k = start; ; ) {
            if (i > mid && j > end) break;
            if (j > end) nums[k++] = array[i++];
            else if (i > mid) nums[k++] = array[j++];
            else  if ( array[i] < array[j]) nums[k++] = array[i++];
            else nums[k++] = array[j++];
        }
    }


}
