package leetcode_jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J40_2 {
    public static void main(String[] args) {
//        new J40().getLeastNumbers(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 2);
    }

    //输入整数数组 arr ，找出其中最小的 k 个数
    // 4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//    输入：arr = [0,1,2,1], k = 1
//    输出：[0]
//    public int[] getLeastNumbers(int[] arr, int k) {
//        quick(arr, 0, arr.length - 1, k - 1);//k转换成索引
//        return Arrays.copyOf(arr, k);
//
//    }
//
//    private void quick(int[] arr, int start, int end, int k) {
//
//        int j = move(arr, start, end);
//        if (j == k || j == k + 1) {
//        } else if (j < k) {
//            quick(arr, j + 1, end, k);
//        } else if (j > k + 1) {
//            quick(arr, start, j-1, k);
//        }
//    }
//
//    //移动首元素，最终小于等于它的在其左边，大于它的在其右边，返回此时首元素的索引。
//    private int move(int[] arr, int start, int end) {
//        int j = start, value = arr[start];
//        for (int i = start + 1; i <= end; ) {
//            if (arr[i] <= value) {
//                swap(arr, i, j);
//                j++;
//                i++;
//            } else {
//                swap(arr, i, end);
//                end--;
//            }
//        }
//        return j;
//    }
//
//    private void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }


}
