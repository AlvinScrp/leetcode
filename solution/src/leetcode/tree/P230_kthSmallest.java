package leetcode.tree;

import java.util.Stack;

public class P230_kthSmallest {

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

        System.out.println(kthSmallest(root,3));


    }


   static int count = 0;

    public static int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }

        TreeNode node=root;
        Stack<TreeNode> stack=new Stack<>();
        while (true){
            if (node!=null){
                stack.push(node);
                node=node.left;
            }else if(!stack.isEmpty()){
                node=  stack.pop();
                if(--k==0){
                    return node.val;
                }
                node=node.right;
            }else {
                break;
            }
        }
        return 0;

    }


}
