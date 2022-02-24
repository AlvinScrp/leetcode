package leetcode.p301_400;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation


public class P385 {
    class NestedInteger {

        int value;
        boolean isInteger = false;

        List<NestedInteger> list = new ArrayList<>();

        public NestedInteger() {
        }

        public NestedInteger(int value) {
            this.value = value;
            isInteger = true;
        }

        public boolean isInteger() {
            return isInteger;
        }

        public Integer getInteger() {
            return value;
        }

        public void setInteger(int value) {
            this.value = value;
            isInteger = true;
        }

        public void add(NestedInteger ni) {
            isInteger = false;
            list.add(ni);
        }

        public List<NestedInteger> getList() {
            return list;
        }
    }

    public static void main(String[] args) {

        new P385().deserialize("324");

    }

    public NestedInteger deserialize(String s) {
        if (s.length() == 0) return new NestedInteger();
        if (!s.startsWith("[")) return new NestedInteger(Integer.parseInt(s));
        Stack<NestedInteger> stack = new Stack<>();
        String numBuilder = "";
        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            if (aChar == '[') {
                stack.push(new NestedInteger());
            } else if (aChar == ',' || aChar == ']') {
                if (numBuilder.length() > 0) {
                    stack.peek().add(new NestedInteger(Integer.parseInt(numBuilder)));
                    numBuilder ="";
                }
                if (aChar == ']' && stack.size() > 1) {
                    NestedInteger child = stack.pop();
                    stack.peek().add(child);
                }
            } else {
                numBuilder+=(aChar);
            }
        }
        return stack.pop();

    }
}
