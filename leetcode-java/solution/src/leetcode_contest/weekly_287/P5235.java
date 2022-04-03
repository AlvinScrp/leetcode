package leetcode_contest.weekly_287;

public class P5235 {

    public static void main(String[] args) {
//        System.out.println(new P5219().convertTime("02:30", "04:35"));
//        System.out.println(new P5219().convertTime("11:00", "11:01"));
//        System.out.println(new P1().minDeletion(new int[]{1, 1, 2, 2, 3, 3}));

    }

    public int convertTime(String current, String correct) {

        int d = parse(correct) - parse(current);
        if (d <= 0) return 0;
        int[] nums = new int[]{60, 15, 5, 1};
        int count = 0;
        for (int num : nums) {
            count += d / num;
            if (d % num == 0) {
                return count;
            } else {
                d = d % num;
            }
        }
        return count;

    }

    private int parse(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60
                + Integer.parseInt(time.split(":")[1]);
    }


}
