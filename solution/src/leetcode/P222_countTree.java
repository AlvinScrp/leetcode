package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P222_countTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.right=new TreeNode(3);

        System.out.println(countNodes(root));


    }


   static int count = 0;

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDeep = findDeep(root, -1);
        System.out.println("maxDeep:"+maxDeep);
        if(maxDeep==0){
            return 1;
        }
        count = (int) (Math.pow(2, maxDeep) - 1);
        dfs(root, 0, maxDeep);
        return count;
    }

    private static void dfs(TreeNode node, int deep, int maxDeep) {
        if (node == null) {
            return;
        }
        if (deep == maxDeep - 1) {
            count += (node.left != null ? 1 : 0);
            count += (node.right != null ? 1 : 0);
            return;
        }
        dfs(node.left, deep + 1, maxDeep);
        dfs(node.right, deep + 1, maxDeep);
    }

    private static int findDeep(TreeNode node, int maxDeep) {
        while (node != null) {
            maxDeep++;
            node = node.left;
        }
        return maxDeep;
    }


}
