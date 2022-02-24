package leetcode_jianzhioffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class J40_3 {
    public static void main(String[] args) {
        new J40_3().getLeastNumbers(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 100);
    }


    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int a : arr) {
            if(queue.size()<k){
                queue.offer(a);
            }else if(queue.peek() > a){
                queue.poll();
                queue.offer(a);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            res[i] = queue.poll();
        }
//        System.out.println(Arrays.toString(res));
        return res;
    }


}
