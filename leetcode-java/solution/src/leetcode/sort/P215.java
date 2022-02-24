package leetcode.sort;

import java.util.PriorityQueue;

public class P215 {

    public static void main(String[] args) {
        System.out.println(new P215().findKthLargest(new int[]{-1, 2, 0}, 2));
    }

    public int findKthLargest(int[] nums, int k) {

        quick(nums, 0, nums.length - 1, k - 1);//k转换成索引
        return nums[k - 1];

    }

    private void quick(int[] arr, int start, int end, int k) {

        int j = move(arr, start, end);
        if (j == k) {
        } else if (j < k) {
            quick(arr, j + 1, end, k);
        } else if (j > k) {
            quick(arr, start, j - 1, k);
        }
    }

    //移动首元素，最终大于等于它的在其左边，小于它的在其右边，返回原首元素的索引。
    private int move(int[] arr, int start, int end) {
        int i = start + 1, j = end, value = arr[start];

        while (true) {
            while (i <= end && arr[i] > value) i++;
            while (j >= start && arr[j] < value) j--;
            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            } else break;
        }
        swap(arr, start, j);
        return j;

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

class P215_2 {

    public static void main(String[] args) {
        System.out.println(new P215().findKthLargest(new int[]{-1, 2, 0}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) queue.poll();
        }
        return queue.poll();
    }


}
