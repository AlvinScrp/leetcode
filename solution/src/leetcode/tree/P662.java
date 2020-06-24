package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P662 {

    int max;

    public int widthOfBinaryTree(TreeNode root) {

        max = 0;
        List<List<Integer>> positions = new ArrayList<>();
        dfs(root, 0, 0, positions);
        for (List<Integer> position : positions) {
            max = Math.max(max, position.get(position.size() - 1) - position.get(0) + 1);
        }
        return max;
    }

    private void dfs(TreeNode root, int deep, int position, List<List<Integer>> positions) {

        if (root == null) return;
        if (positions.size() == deep) {
            positions.add(new ArrayList<>());
        }
        positions.get(deep).add(position);

        dfs(root.left, deep + 1, position << 1, positions);
        dfs(root.right, deep + 1, (position << 1) + 1, positions);
    }


}
