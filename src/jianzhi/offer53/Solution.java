package jianzhi.offer53;

public class Solution {
    // 不是最优解，当数组都是同一个数，会变成O(n)级别，最优解是找到两个边界值，相减得出长度
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int num = 0;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (target == nums[mid]) {
                int l = mid - 1;
                while (l >= 0 && nums[l] == target) {
                    num ++;
                    l --;
                }
                while (mid < nums.length && nums[mid] == target) {
                    mid ++;
                    num ++;
                }
                break;
            } else if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 2};
        Solution solution = new Solution();
        solution.search(nums, 3);
    }
}
