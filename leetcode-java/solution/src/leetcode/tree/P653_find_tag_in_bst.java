package leetcode.tree;

import java.util.*;

public class P653_find_tag_in_bst {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


//    public boolean findTarget(TreeNode root, int k) {
//
//        Stack<TreeNode> s = new Stack<>();
//        List<TreeNode> res = new ArrayList<>();
//
//        TreeNode node = root;
//
//        boolean find = false;
//        while (true) {
//            if (node != null) {
//                s.push(node);
//                node = node.left;
//            } else if (!s.isEmpty()) {
//                node = s.pop();
//                res.add(node);
//                if (checkSum(res, k)) {
//                    find = true;
//                    break;
//                }
//                node = node.right;
//
//            } else {
//                break;
//            }
//        }
//        return find;
//
//
//    }
//
//    public boolean checkSum(List<TreeNode> res, int k) {
//        int size = res.size();
//        int last = res.get(size - 1).val;
//        boolean find = false;
//        for (int i = 0; i < size - 1; i++) {
//            if (k == res.get(i).val + last) {
//                find = true;
//                break;
//            }
//        }
//        return find;
//
//    }

    HashSet<Integer> set;

    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return dfs(root, k);
    }

    private boolean dfs(TreeNode node, int k) {
        if (node == null) return false;
        if (set.contains(k - node.val)) return true;

        set.add(node.val);
        return dfs(node.left, k) || dfs(node.right, k);
    }


}
