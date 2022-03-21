import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class A210 {

    public static void main(String[] args) {
        int[] ans = new A210().new Solution()
                .findOrder(2, new int[][]{{1, 0}});
        System.out.print("[");
        for (int an : ans) System.out.print(an + ",");
        System.out.println("]");

        ans = new A210().new Solution()
                .findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        System.out.print("[");
        for (int an : ans) System.out.print(an + ",");
        System.out.println("]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {


            HashSet<Integer>[] sets = new HashSet[numCourses];
            int[] inDegree = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                sets[i] = new HashSet<>();
            }
            for (int[] pre : prerequisites) {
                sets[pre[1]].add(pre[0]);
                inDegree[pre[0]]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) queue.offer(i);
            }

            int[] ans = new int[numCourses];
            int count = 0;
            while (!queue.isEmpty()) {
                int pre = queue.poll();
                ans[count] = pre;
                count++;

                HashSet<Integer> set = sets[pre];
                for (Integer post : set) {
                    inDegree[post]--;
                    if (inDegree[post] == 0) {
                        queue.add(post);
                    }
                }
            }
            return count == numCourses ? ans : new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







