package jianzhi.offer03;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (nums[num] == num && num != i) {
                return num;
            }
            if (nums[num] != num) {
                swap(nums, i, num);
                i --;
            }
        }
        return -1;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
