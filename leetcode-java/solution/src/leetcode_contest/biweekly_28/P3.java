package leetcode_contest.biweekly_28;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P3 {

    public static void main(String[] args) {
        System.out.println();
//        new P3().minSumOfLengths(new int[]{3, 1, 1, 1, 5, 1, 2, 1}, 3);
//        new P3().minSumOfLengths(new int[]{3, 2, 2, 4, 3}, 3);
        new P3().minSumOfLengths(new int[]{31, 1, 1, 18, 15, 3, 15, 14}, 33);

    }

    class Value {
        int l, r, d;

        public Value(int l, int r) {
            this.l = l;
            this.r = r;
            d = r - l + 1;
        }

        @Override
        public String toString() {
            return "Value{" +
                    "l=" + l +
                    ", r=" + r +
                    ", d=" + d +
                    '}';
        }
    }

    public int minSumOfLengths(int[] arr, int target) {

        PriorityQueue<Value> values = new PriorityQueue<>(Comparator.comparingInt(o -> o.d));
        List<Value> values2 = new ArrayList<>();
        int sum = arr[0];
        for (int i = 0, j = 0; i < arr.length && j < arr.length; ) {
            if (sum == target) {
                values.add(new Value(i, j));
                values2.add(new Value(i, j));
                if (j == arr.length - 1) break;
                sum -= arr[i++];
                sum += arr[++j];
            } else if (sum < target) {
                if (j == arr.length - 1) break;
                sum += arr[++j];
            } else {
                sum -= arr[i++];
            }
        }
        System.out.println(values2);


        if (values.isEmpty()) return -1;
        Value v1 = values.poll();
        Value v2 = null;

        while (!values.isEmpty()) {
            Value temp = values.poll();
            if (temp.l > v1.r || temp.r < v1.l) {
                v2 = temp;
                break;
            }
        }
        return v2 != null ? (v1.d + v2.d) : -1;
    }


}
