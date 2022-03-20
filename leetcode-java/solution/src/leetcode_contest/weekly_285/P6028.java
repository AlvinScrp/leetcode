package leetcode_contest.weekly_285;

import java.util.Stack;

public class P6028 {

    public static void main(String[] args) {
        System.out.println(countCollisions("RLRSLL"));
        System.out.println(countCollisions("LLRR"));
        System.out.println(countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));

    }

    public static int countCollisions(String directions) {

        int count = 0;
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < directions.length(); i++) {
            char c = directions.charAt(i);
            if (s.isEmpty()) {
                if (c != 'L') {
                    s.push(c);
                }

            } else {
                char pre = s.peek();
                if (pre == 'R' && c == 'R') {
                    s.push(c);
                } else if (pre == 'R' && (c == 'S' || c == 'L')) {
                    count += (c == 'S' ? 1 : 2);
                    s.pop();
                    while (!s.isEmpty()) {
                        char pop = s.pop();
                        if (pop == 'R') {
                            count++;
                        } else {
                            break;
                        }
                    }
                    s.push('S');
                } else if (pre == 'S' && c == 'R') {
                    s.pop();
                    s.push('R');
                } else if (pre == 'S' && c == 'S') {

                } else if (pre == 'S' && c == 'L') {
                    count++;
                }
            }
        }
        return count;

    }


}
