package leetcode.p101_200;

import leetcode.TreeNode;
import leetcode.sort.ListNode;

public class P109 {

    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        for (ListNode node = head; node != null; size++, node = node.next) ;
        int[] nums = new int[size];
        ListNode node = head;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = node.val;
            node = node.next;
        }

        TreeNode ans = sortArrayToBST(nums, 0, nums.length - 1);
        return ans;


    }

    private TreeNode sortArrayToBST(int[] nums, int lo, int hi) {
        if (lo > hi) return null;

        int mid = (hi - lo) / 2 + lo;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortArrayToBST(nums, lo, mid - 1);
        node.right = sortArrayToBST(nums, mid + 1, hi);
        return node;

    }
}
