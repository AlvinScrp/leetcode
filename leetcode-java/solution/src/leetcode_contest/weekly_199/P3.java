package leetcode_contest.weekly_199;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P3 {

    public static void main(String[] args) {

        System.out.println();

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.right=new TreeNode(3);

        System.out.println(new P3().countPairs(root,3));
    }

    int count;

    public int countPairs(TreeNode root, int distance) {
        count = 0;
        leaveDeeps(root, distance);
        return count;

    }

    private List<Integer> leaveDeeps(TreeNode root, int distance) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (root.left == null && root.right == null) {
            res.add(1);
            return res;
        }

        List<Integer> lefts = leaveDeeps(root.left, distance);
        List<Integer> rights = leaveDeeps(root.right, distance);

        for (Integer left : lefts) {
            for (Integer right : rights) {
                if (left + right <= distance) {
                    count++;
                }
            }
        }


        for (Integer left : lefts) {
            res.add(left + 1);
        }
        for (Integer right : rights) {
            res.add(right + 1);
        }
        return res;
    }


}


class TreeNode {
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

