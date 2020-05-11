package leetcode.tree;

public class P606 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
     * <p>
     * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 二叉树: [1,2,3,4]
     * 1
     * /   \
     * 2     3
     * /
     * 4
     * <p>
     * 输出: "1(2(4))(3)"
     * <p>
     * 解释: 原本将是“1(2(4)())(3())”，
     * 在你省略所有不必要的空括号对之后，
     * 它将是“1(2(4))(3)”。
     * 示例 2:
     * <p>
     * 输入: 二叉树: [1,2,3,null,4]
     * 1
     * /   \
     * 2     3
     * \
     * 4
     * <p>
     * 输出: "1(2()(4))(3)"
     * <p>
     * 解释: 和第一个示例相似，
     * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
     *
     * @param t
     * @return
     */

    public String tree2str(TreeNode t) {
        return traversal(t, true);

    }

    public String traversal(TreeNode node, boolean isRoot) {

        if (node == null) {
            return isRoot?"":"()";
        }

        StringBuilder sb = new StringBuilder();

        sb.append(isRoot ? "" : "(");
        sb.append(node.val);
        String left = traversal(node.left, false);
        String right = traversal(node.right, false);
        if (right.length() == 2) {
            sb.append(left.length() > 2 ? left : "");
        } else {
            sb.append(left);
            sb.append(right);
        }

        sb.append(isRoot ? "" : ")");
        return sb.toString();

    }

}
