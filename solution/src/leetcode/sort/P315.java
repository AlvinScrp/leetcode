package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P315 {

    public static void main(String[] args) {
        System.out.println(new P315().countSmaller(new int[]{5, 2, 6, 1}));
//        System.out.println(new P315().countSmaller(new int[]{7, 3, 5, 2, 4, 1, 6, 8}));
    }

    class NumBean {
        int val;
        int index;
        int count;

        public NumBean(int val, int index, int count) {
            this.val = val;
            this.index = index;
            this.count = count;
        }

        @Override
        public String toString() {
            return "" + val + ":" + count;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        if (nums.length == 1) return Arrays.asList(0);

        NumBean[] beans = new NumBean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            beans[i] = new NumBean(nums[i], i, 0);
        }
        dividerAndMerge(beans, 0, nums.length - 1);

        int[] ans = new int[nums.length];
        for (NumBean bean : beans) ans[bean.index] = bean.count;
        for (int count : ans) res.add(count);

//        System.out.println(Arrays.toString(beans));
        return res;


    }


    public void dividerAndMerge(NumBean[] nums, int lo, int hi) {

        if (lo >= hi) return;
        int mid = (hi - lo) / 2 + lo;
        dividerAndMerge(nums, lo, mid);
        dividerAndMerge(nums, mid + 1, hi);
        NumBean[] temp = Arrays.copyOfRange(nums, lo, hi + 1);
        merge(nums, lo, mid, temp);

    }

    private void merge(NumBean[] nums, int lo, int mid, NumBean[] temp) {

        int i = 0, j = mid - lo + 1, k = lo;
        int jStart = j, jEnd = temp.length - 1;
        while (i < mid - lo + 1 && j < temp.length) {
            if (temp[i].val <= temp[j].val) {
                temp[i].count += (j - jStart);
                nums[k++] = temp[i++];

            } else nums[k++] = temp[j++];
        }
        while (i < mid - lo + 1) {
            temp[i].count += (jEnd - jStart + 1);
            nums[k++] = temp[i++];
        }
        while (j < temp.length) {
            nums[k++] = temp[j++];
        }
    }
}
