package jianzhi.offer53;

public class Solution2 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        int numsSum = 0;
        for (int i = 0; i < nums.length; i++) {
            numsSum += nums[i];
        }
        return sum - numsSum;
    }
}
