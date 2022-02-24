package leetcode.p101_200;

import java.util.PriorityQueue;

public class P179 {
    //    输入: [3,30,34,5,9]
//    输出: 9534330
    public String largestNumber(int[] nums) {

        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for (int num : nums) queue.add(String.valueOf(num));
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) sb.append(queue.poll());
        String ans = sb.toString();
        return ans.startsWith("0")?"0":ans;
    }
}
