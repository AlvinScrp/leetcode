package leetcode.tree;

import java.util.*;
import java.util.stream.Collectors;

public class P652 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//    示例 1：
//
//            1
//            / \
//           2   3
//          /   / \
//         4   2   4
//            /
//           4
//    下面是两个重复的子树：
//
//            2
//            /
//           4
//    和
//
//    4


    Map<String, Integer> stringCounts;
    List<TreeNode> res;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        res = new LinkedList<>();
        stringCounts = new HashMap<>();
        treeToString(root);
        return res;

    }

    public String treeToString(TreeNode node) {
        if (node == null) return "#,";
        String s = node.val + "," + treeToString(node.left) + treeToString(node.right);

        stringCounts.put(s,stringCounts.getOrDefault(s,0)+1);
        if(stringCounts.get(s)==2){
            res.add(node);
        }
        return s;


    }

}
