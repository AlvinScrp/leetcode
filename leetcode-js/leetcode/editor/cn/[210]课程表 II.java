import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class A210 {

    public static void main(String[] args) {
        System.out.println(new A210().new Solution().findOrder(2, new int[][]{{1, 0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Set<Integer>[] out = new Set[numCourses];
            int[] inDegree = new int[numCourses];
            for (int[] p : prerequisites) {
                if (out[p[1]] == null) out[p[1]] = new HashSet<>();
                out[p[1]].add(p[0]);
                inDegree[p[0]]++;
            }
            Deque<Integer> courses = new ArrayDeque<>();
            for (int course = 0; course < numCourses; course++) {
                if (inDegree[course] == 0) {
                    courses.addLast(course);
                }
            }
            int[] ans = new int[numCourses];
            int k = 0;
            while (!courses.isEmpty()) {
                int course = courses.removeFirst();
                ans[k++] = course;

                Set<Integer> integers = out[course];
                if (integers != null) {
                    for (Integer i : integers) {
                        inDegree[i]--;
                        if (inDegree[i] == 0) courses.addLast(i);
                    }
                }

            }

            return k == numCourses ? ans : new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}





