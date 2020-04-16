package leetcode;

public class P33_search_in_rotated_sorted_array {

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 6, 7, 8, 9, 0, 1, 2,};
//        int[] nums = {1, 2, 3, 4, 5};
        int target = 9;
        System.out.println(search(nums, target));

    }

    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * <p>
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * <p>
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * <p>
     * 你可以假设数组中不存在重复的元素。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {

        return binarySearch(nums, 0, nums.length - 1, target);
    }

    //    int[] nums = {3, 4, 5, 6, 7, 8, 9, 0, 1, 2,}; target=2
    public static int binarySearch(int[] nums, int left, int right, int target) {

        if (left > right) {
            return -1;
        }
        int middle = (right - left) / 2 + left;
        int index;
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[left] <= nums[middle]) {
            if (nums[left] <= target && target <= nums[middle]) {
                index = binarySearch(nums, left, middle, target);
            }else {
                index = binarySearch(nums, middle + 1, right, target);
            }
        }else {
            if(nums[middle] <= target && target <= nums[right]){
                index=binarySearch(nums,middle + 1, right, target);
            }else {
                index=binarySearch(nums,left,middle,target);
            }
        }
        return index;
    }
}
