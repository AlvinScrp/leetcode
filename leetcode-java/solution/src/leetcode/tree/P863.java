package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P863 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        rotate(root, target);

        TreeNode node = root;
        Stack<TreeNode> s = new Stack<>();

        while (node != null) {

            if (node.val == target.val){
                dfs(node,K,res);
                break;
            }
            s.add(node);
            node = node.left;
        }
        int count = 1;
        while (!s.isEmpty()) {
            node = s.pop();
            if (K == count) {
                res.add(node.val);
                break;
            }
            dfs(node.right,K-count-1,res);
            count++;
        }
        return res;


    }

    private boolean rotate(TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root.val == target.val) return true;
        if (rotate(root.right, target)) {
            swap(root);
            return true;
        }
        return rotate(root.left, target);

    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    private void dfs(TreeNode node, int k, List<Integer> res) {
        if (node == null) return;
        if (k == 0) {
            res.add(node.val);
            return;
        }
        dfs(node.left, k - 1, res);
        dfs(node.right, k - 1, res);
    }
}
