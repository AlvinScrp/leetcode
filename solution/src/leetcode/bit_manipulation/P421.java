package leetcode.bit_manipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P421 {

    /**
     * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 2^31 。
     * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
     * 你能在O(n)的时间解决这个问题吗？
     * <p>
     * 输入: [3, 10, 5, 25, 2, 8]
     * 输出: 28
     * 解释: 最大的结果是 5 ^ 25 = 28.
     *
     * @return
     */

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(new P421().findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8})));
        System.out.println(Integer.toBinaryString(new P421().findMaximumXOR2(new int[]{3, 10, 5, 25, 2, 8})));
    }

    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();

        public TrieNode() {

        }
    }

    public int findMaximumXOR2(int[] nums) {

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int mask = 1 << Integer.toBinaryString(max).length();

        TrieNode trie = new TrieNode();
        int maxXor = 0, curXor;
        for (int i = 0; i < nums.length; i++) {
            String str = Integer.toBinaryString(nums[i] | mask).substring(1);
//            System.out.println(str);
            TrieNode node = trie, xorNode = trie;

            curXor = 0;
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);

                char oxrCh = ch == '1' ? '0' : '1';
                if (xorNode.children.containsKey(oxrCh)) {
                    curXor = (curXor << 1) | 1;
                    xorNode = xorNode.children.get(oxrCh);
                } else {
                    curXor = curXor << 1;
                    xorNode = xorNode.children.get(ch);
                }

            }
            maxXor = Math.max(maxXor, curXor);
        }
        return maxXor;


    }

    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = nums[0];
        for (int num : nums) max = Math.max(max, num);
        int L = Integer.toBinaryString(max).length();
        int maxXor = 0, curXor = 0;
        for (int i = L - 1; i >= 0; i--) {
            maxXor <<= 1;
            curXor = maxXor | 1;

            Set<Integer> pres = new HashSet<>();
            for (int num : nums) {
                int pre = num >> i;
                if (pres.contains(curXor ^ pre)) {
                    maxXor = curXor;
                    break;
                }
                pres.add(pre);
            }
        }
        return maxXor;
    }


}
