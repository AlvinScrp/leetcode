package leetcode.p501_600;

import java.util.Arrays;

public class P565 {
    public static void main(String[] args) {
        System.out.println(new P565().arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }

    public int arrayNesting(int[] nums) {
        int max = 0;
        boolean[] visited=new boolean[nums.length];
        Arrays.fill(visited,false);
        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                int j = i;
                int count = 1;
                while (nums[j] != i) {
                    j = nums[j];
                    count++;
                }
                max = Math.max(max, count);
                visited[i]=true;
            }
        }
        return max;
    }
}
