package leetcode.p401_500;

public class P495 {

    public static void main(String[] args) {
        System.out.println(new P495().findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(new P495().findPoisonedDuration(new int[]{1, 2}, 2));
    }

    //    public int findPoisonedDuration(int[] timeSeries, int duration) {
//        int res = 0;
//        for (int i = 0; i < timeSeries.length; ) {
//            int j = i;
//            for (; j < timeSeries.length - 1; j++) {
//                if (timeSeries[j] + duration < timeSeries[j + 1]) break;
//            }
//            res += (timeSeries[j] + duration - timeSeries[i]);
//            if (j == timeSeries.length - 1) break;
//            i = j + 1;
//        }
//        return res;
//    }
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        for (int i = 0; i < timeSeries.length - 1;i++ ) {
            res += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }
        return res + duration;
    }
}
