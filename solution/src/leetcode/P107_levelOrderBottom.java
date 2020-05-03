package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class P107_levelOrderBottom {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        List<TreeNode> nodes = Arrays.asList(root);
        dfs(nodes, res);
        return res;

    }

    private static void dfs(List<TreeNode> nodes, List<List<Integer>> res) {
        if (nodes == null || nodes.size() == 0) {
            return;
        }
        List<TreeNode> children = getChildren(nodes);
        dfs(children, res);
        res.add(nodes.stream().map(child -> child.val).collect(Collectors.toList()));
    }

    private static List<TreeNode> getChildren(List<TreeNode> nodes) {
        List<TreeNode> children = new LinkedList<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                children.add(node.left);
            }
            if (node.right != null) {
                children.add(node.right);
            }
        }
        return children;
    }

//    private static  List<TreeNode> bfs( List<TreeNode> nodes, int deep, List<List<Integer>> res) {
//       if(nodes==null||nodes.size()==0){
//           return ;
//       }
//       List<TreeNode> children=new LinkedList<>();
//        for (TreeNode node : nodes) {
//            if(node.left!=null){
//                children.add(node.left);
//            }
//            if(node.right!=null){
//                children.add(node.right);
//            }
//        }
//        return children;
//
//
//
//
//    }
}
