import java.util.*;

public class Main {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        int index = 0;
//        while (in.hasNextInt()) {
//            nums[index++] = in.nextInt();
//            if (index == n) break;
//        }
//        int count = in.nextInt();
//        long ans = getResult(nums, count);
//        System.out.println(ans);


//        int ans = getResult(new int[]{3, 2, 3, 4, 2}, 2);
        int ans = getResult(new int[]{95, 88, 83, 64, 100}, 2);
        System.out.println(ans);

    }
//    5
//            95 88 83 64 100
//            2

    private static int getResult(int[] nums, int count) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        if (count > list.size() / 2) return -1;

        int ans = 0;
        for (int i = 0, j = list.size() - 1, k = 0; k < count; k++) {
            ans += list.get(i + k);
            ans += list.get(j - k);
        }
        return ans;
    }
}