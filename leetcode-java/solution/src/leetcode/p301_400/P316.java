package leetcode.p301_400;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class P316 {
    public static void main(String[] args) {
        System.out.println(new P316().removeDuplicateLetters("cbacdcbc"));//acdb
    }

    public String removeDuplicateLetters(String s) {
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch]--;
            if (inStack[ch]) continue;
            while (!stack.isEmpty() && stack.peek() > ch) {
                if (count[stack.peek()] == 0) break;
                inStack[stack.pop()] = false;
            }

            stack.push(ch);
            inStack[ch] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
