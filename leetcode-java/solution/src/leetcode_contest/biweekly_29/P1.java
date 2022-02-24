package leetcode_contest.biweekly_29;

public class P1 {

    public static void main(String[] args) {
        System.out.println();
        System.out.println(average(new int[]{8000,9000,2000,3000,6000,1000}));

    }

    public static double average(int[] salary) {
        int max = salary[0], min = salary[0], sum = 0;

        for (int i : salary) {
            max = Math.max(i, max);
            min = Math.min(i, min);
            sum += i;
        }
        sum -= max;
        sum -= min;
        return sum / ((salary.length - 2) * 1.0d);
    }


}
