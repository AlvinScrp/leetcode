package leetcode.sort;

import java.util.Arrays;
import java.util.Random;

public class P912 {

//    public int[] sortArray(int[] nums) {
//
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 2, 4, 3, 6};
//        int[] nums = new int[]{5, 4, 3, 2, 1, 0};
//        int[] nums = new int[]{2, 3, 1};
//        System.out.println(Arrays.toString(new P912().bubbleSort(Arrays.copyOf(nums, nums.length))));
//        System.out.println(Arrays.toString(new P912().selectSort(Arrays.copyOf(nums, nums.length))));
//        System.out.println(Arrays.toString(new P912().insertionSort(Arrays.copyOf(nums, nums.length))));
//        System.out.println(Arrays.toString(new P912().mergeSort(Arrays.copyOf(nums, nums.length))));
//        System.out.println(Arrays.toString(new P912().quickSort1(Arrays.copyOf(nums, nums.length))));
        System.out.println(Arrays.toString(new P912().quickSort2(Arrays.copyOf(nums, nums.length))));
        System.out.println(Arrays.toString(new P912().heapSort(Arrays.copyOf(nums, nums.length))));

    }


    /**
     * （无序区，有序区）。
     * 从无序区透过交换找出最大元素放到有序区前端。
     *
     * @param nums
     * @return
     */
    public int[] bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) swap(nums, j, j + 1);
            }
        }
        return nums;
    }

    /**
     * （有序区，无序区）。
     * 在无序区里找一个最小的元素跟在有序区的后面。对数组：比较得多，换得少。
     *
     * @param nums
     * @return
     */
    public int[] selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) swap(nums, j, i);
            }
        }
        return nums;
    }


    /**
     * 有序区，无序区）。
     * 把无序区的第一个元素插入到有序区的合适的位置。对数组：比较得少，换得多。
     */
    public int[] insertionSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (nums[j] < nums[j - 1]) swap(nums, j, j - 1);
                else break;
            }
        }
        return nums;

    }

    public int[] mergeSort(int[] nums) {
        dividerAndMerge(nums, 0, nums.length - 1);
        return nums;
    }


    public void dividerAndMerge(int[] nums, int lo, int hi) {

        if (lo >= hi) return;
        int mid = (hi - lo) / 2 + lo;
        dividerAndMerge(nums, lo, mid);
        dividerAndMerge(nums, mid + 1, hi);
        int[] temp = Arrays.copyOfRange(nums, lo, hi + 1);
        merge(nums, lo, mid, temp);

    }

    private void merge(int[] nums, int lo, int mid, int[] temp) {

        int i = 0, j = mid - lo + 1, k = lo;
        while (i < mid - lo + 1 && j < temp.length) {
            if (temp[i] < temp[j]) nums[k++] = temp[i++];
            else nums[k++] = temp[j++];
        }
        while (i < mid - lo + 1) nums[k++] = temp[i++];
        while (j < temp.length) nums[k++] = temp[j++];
    }

    public int[] quickSort1(int[] nums) {
        quick1(nums, 0, nums.length - 1);
        return nums;
    }

    private void quick1(int[] nums, int lo, int hi) {
        if (lo >= hi) return;

        int random = lo + new Random().nextInt(hi - lo + 1);
        swap(nums, lo, random);

        int i = lo + 1, j = hi;
        int pivot = nums[lo];

        while (i < j) {
            while (i <= hi && nums[i] < pivot) i++;
            while (j >= lo + 1 && nums[j] > pivot) j--;

            if (i < j) swap(nums, i, j);
        }
        if (nums[j] < nums[lo]) swap(nums, lo, j);

        quick1(nums, lo, j - 1);
        quick1(nums, j + 1, hi);
    }

    public int[] quickSort2(int[] nums) {
        quick2(nums, 0, nums.length - 1);
        return nums;
    }

    //5, 1, 1, 2, 0, 0
    private void quick2(int[] nums, int lo, int hi) {
        if (lo >= hi) return;

//        int random = lo + new Random().nextInt(hi - lo + 1);
//        swap(nums, hi, random);

        int i = lo, j = lo;
        int pivot = nums[hi];

        while (j < hi) {
            if (nums[j] > pivot) {
                j++;
            } else {
                swap(nums, i, j);
                j++;
                i++;
            }
        }
        swap(nums, i, hi);


        quick2(nums, lo, i - 1);
        quick2(nums, i + 1, hi);
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;

    }

    public int[] shellSort(int[] nums) {
        int length = nums.length;
        for (int gap = length >> 1; gap > 0; gap = gap >> 1) {
            for (int i = gap; i < length; i++) {
                for (int j = i; j >= gap && nums[j] < nums[j - gap]; j -= gap) {
                    swap(nums, j, j - gap);
                }
            }

        }
        return nums;
    }


    //5, 1, 2, 4, 3, 6
    public int[] heapSort(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return nums;
        int length = nums.length;

        //1.heapify 构建一个大顶堆。
        //从最后一个非叶子节点开始处理，依次处理其堆序。最终处理根节点
        //所谓堆序：即任意节点值均不小于其子节点值。根节点为整个堆的最大值。
        for (int i = (length >> 1) - 1; i >= 0; i--) {
            siftDown(nums, i, length);
        }
        //2.交换堆顶根节点(0)与当前堆最后节点(i)的值，此时视角只需要停留在 0 ~ i-1，
        //3.重新构建 0 ~ i-1的大顶堆，只有根节点不满足堆序，我们只要调整根节点堆序
        for (int j = length - 1; j > 0; j--) {
            swap(nums, 0, j);
            siftDown(nums, 0, j);
        }
        return nums;

    }

    /**
     * 若此节点值大于其子节点值，满足堆序，终止此次处理。
     * 否则 交换此节点与其子节点中值最大的节点值。处理此子节点的堆序
     * @param i 开始索引(包括)
     * @param j 结束索引(不包括)
     */
    private void siftDown(int[] nums, int i, int j) {
        while (i < j) {
            int l = (i << 1) + 1, r = l + 1;
            //如果左右节点均超过结束索引
            if (l >= j && r >= j) break;
            //取到左右节点中值较大的索引。
            int childIndex = r < j && nums[r] >= nums[l] ? r : l;
           //如果节点不小于子节点最大值，跳出
            if (nums[i] >= nums[childIndex]) break;
            swap(nums, i, childIndex);
            //处理该子节点堆序
            i = childIndex;
        }
    }
}
