package leetcode_jianzhioffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class J45 {
    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。
     * 输入: [10,2]   输出: "102"
     * <p>
     * 输入: [3,30,34,5,9]  输出: "3033459"
     */

    public static void main(String[] args) {
        System.out.println(new J45().minNumber(new int[]{0, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }

    public String minNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        for (int num : nums) queue.offer(String.valueOf(num));
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) sb.append(queue.poll());
        return sb.toString();
    }
}
