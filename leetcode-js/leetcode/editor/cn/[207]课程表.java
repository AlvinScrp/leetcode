import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class A207 {

    public static void main(String[] args) {
        // System.out.println(new A207().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

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
            int k = 0;
            while (!courses.isEmpty()) {
                int course = courses.removeFirst();
                k++;

                Set<Integer> integers = out[course];
                if (integers != null) {
                    for (Integer i : integers) {
                        inDegree[i]--;
                        if (inDegree[i] == 0) courses.addLast(i);
                    }
                }

            }

            return k == numCourses ;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







