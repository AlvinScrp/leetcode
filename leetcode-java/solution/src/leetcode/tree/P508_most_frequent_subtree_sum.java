package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P508_most_frequent_subtree_sum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> sumCountMap;

    public int[] findFrequentTreeSum(TreeNode root) {
        sumCountMap = new HashMap<>();
        traversal(root);
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> sumCount : sumCountMap.entrySet()) {
            maxCount = Math.max(maxCount, sumCount.getValue());
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> sumCount : sumCountMap.entrySet()) {
            if (sumCount.getValue() == maxCount) {
                res.add(sumCount.getKey());
            }
        }
        int[] values = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            values[i] = res.get(i);
        }
        return values;


    }

    private int traversal(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int sum = node.val + traversal(node.left) + traversal(node.right);
        int count = sumCountMap.containsKey(sum) ? (sumCountMap.get(sum) + 1) : 1;
        sumCountMap.put(sum, count);
        return sum;

    }
}
