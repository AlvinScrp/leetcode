package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class P889 {

    public static void main(String[] args) {
        new P889().constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
    }

    /**
     * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
     * 输出：[1,2,3,4,5,6,7]
     *
     * @return
     */
    Map<Integer, Integer> postIndexs;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        postIndexs = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            postIndexs.put(post[i], i);
        }
        TreeNode node = construct(pre, 0, pre.length - 1);
        return node;
    }

    private TreeNode construct(int[] pre, int lo, int hi) {
        if (lo > hi) return null;

        int M = pre[lo];
        TreeNode node = new TreeNode(M);
        if (lo == hi) return node;

        int postHi = postIndexs.get(M);
        int postLow = postHi - (hi - lo);
        int leftLength = postIndexs.get(pre[lo + 1]) - postLow + 1;

        node.left = construct(pre, lo + 1, lo + leftLength);
        node.right = construct(pre, lo + leftLength + 1, hi);
        return node;
    }


}
