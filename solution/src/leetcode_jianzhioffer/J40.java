package leetcode_jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J40 {
    public static void main(String[] args) {
//        int[] res = new J40().getLeastNumbers(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 2);
        int[] res = new J40().getLeastNumbers(new int[]{0,0,0,2,0,5}, 2);
        System.out.println(Arrays.toString(res));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        quick(arr, 0, arr.length - 1, k - 1);//k转换成索引
        return Arrays.copyOf(arr, k);

    }

    private void quick(int[] arr, int start, int end, int k) {

        int j = move(arr, start, end);
        if (j == k || j == k + 1) {
        } else if (j < k) {
            quick(arr, j + 1, end, k);
        } else if (j > k + 1) {
            quick(arr, start, j - 1, k);
        }
    }

    //移动首元素，最终小于等于它的在其左边，大于它的在其右边，返回此时首元素的索引。
    private int move(int[] arr, int start, int end) {
        int i = start + 1, j = end, value = arr[start];

        while (true) {
            while (i <= end && arr[i] < value) i++;
            while (j >= start && arr[j] > value) j--;
            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            }
            else break;
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
