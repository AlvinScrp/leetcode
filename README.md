# leetcode
leetcode解题

算法总结
 
 
动态规划
 
 
catalan数
 
 
双指针
 
 
字典序算法
 
 
回溯
 
递归反转整个链表


KMP算法 字符串匹配算法
https://www.cnblogs.com/yjiyjige/p/3263858.html

 求X的平方根
https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode/
- 牛顿法
- 递归


二叉树中序遍历530，很抽象。
class Solution {
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root,new TreeNode(min));
        return min;
    }
    public TreeNode helper(TreeNode curr,TreeNode prev) {
        if ( curr!=null ) {
            prev = helper(curr.left,prev);
            min = Math.min(Math.abs(prev.val-curr.val),min);
            prev =  helper(curr.right,curr);
        }
        return prev;
    }
}

二叉树的莫里斯(Morris)遍历



二叉树遍历
P94_inorderTree 先序 中序
P145_postorderTraversal   后序

二叉树版最大子序和
[124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)

236.二叉树的最近公共祖先 [题解](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-jian-j/
)

思路
两个节点p,q分为两种情况：

p和q在相同子树中
p和q在不同子树中
从根节点遍历，递归向左右子树查询节点信息
递归终止条件：如果当前节点为空或等于p或q，则返回当前节点
递归遍历左右子树，如果左右子树查到节点都不为空，则表明p和q分别在左右子树中，因此，当前节点即为最近公共祖先；
如果左右子树其中一个不为空，则返回非空节点。
代码
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (!root || root == p || root == q) return root;
        TreeNode *left = lowestCommonAncestor(root->left, p, q);
        TreeNode *right = lowestCommonAncestor(root->right, p, q);
        if (left && right) return root;
        return left ? left : right;
    }
};
