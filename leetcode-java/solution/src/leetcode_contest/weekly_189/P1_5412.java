package leetcode_contest.weekly_189;

public class P1_5412 {

    public static void main(String[] args) {
        System.out.println(busyStudent(new int[]{1, 2, 3}, new int[]{3, 2, 7}, 4));

    }

    //startTime = [1,2,3], endTime = [3,2,7], queryTime = 4  输出1
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        if (startTime == null || startTime.length == 0) return 0;
        int length = startTime.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) count++;
        }
        return count;

    }
}
