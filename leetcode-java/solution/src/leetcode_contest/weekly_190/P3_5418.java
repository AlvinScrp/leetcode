package leetcode_contest.weekly_190;

import java.util.*;

public class P3_5418 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
//        root.left=new TreeNode(3);
//        root.left.left=new TreeNode(3);
//        root.left.right=new TreeNode(1);
//        root.right=new TreeNode(1);
//        root.right.right=new TreeNode(1);
        System.out.println(new P3_5418().pseudoPalindromicPaths(root));
    }

    int count;

    public int pseudoPalindromicPaths(TreeNode root) {
        count = 0;
        dfs(root, new ArrayList<>());
        return count;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (isPalindrome(list)) {
                count++;
                System.out.println(list);
            }
        }
        if (node.left != null) dfs(node.left, list);
        if (node.right != null) dfs(node.right, list);
        list.remove(list.size() - 1);
    }

    private boolean isPalindrome(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        for (Integer val : list) {
            if (set.contains(val)) set.remove(val);
            else set.add(val);
        }
        return set.size() <= 1;
    }
}
