package leetcode_jianzhioffer;

import java.util.ArrayList;
import java.util.List;

public class J06 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        List<Integer> res = new ArrayList<>();

        printNex(head, res);


        int[] values = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            values[i] = res.get(i);
        }
        return values;

    }

    private void printNex(ListNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        printNex(node.next, res);
        res.add(node.val);
    }


}
