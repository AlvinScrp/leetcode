package leetcode_jianzhioffer;

import java.util.Stack;

public class J31 {
    public static void main(String[] args) {
        System.out.println(new J31().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(new J31().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
        System.out.println(new J31().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 2, 1}));
    }

//    pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//
//    pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//    pushed = [1,2,3,4,5], popped = [4,3,5,2,1]

//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        if (pushed == null || popped == null || pushed.length != popped.length)
//            return false;
//
//        Stack<Integer> stack = new Stack<>();
//
//        int i = 0, j = 0;
//        while (i < pushed.length) {
//            if(!stack.isEmpty()&&stack.peek()==popped[j]){
//                stack.pop();
//                j++;
//            }else {
//                stack.push(pushed[i++]);
//            }
//        }
//
//
//        while (!stack.isEmpty() && j < popped.length) {
//            if (stack.pop() == popped[j]) {
//                j++;
//            } else {
//                return false;
//            }
//        }
//        return true;
//
//
//    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length)
            return false;

        Stack<Integer> stack = new Stack<>();

        int i = 0, j = 0;
        while (i < pushed.length) {
            stack.push(pushed[i++]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
