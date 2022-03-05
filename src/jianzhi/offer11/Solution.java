package jianzhi.offer11;

public class Solution {
    public int minArray(int[] numbers) {
        int lo = 0, hi = numbers.length - 1;
        while (lo <= hi) {
            int target = numbers[hi];
            int mid = lo + ((hi - lo) >> 1);
            if (numbers[mid] > target) {
                lo = mid + 1;
            } else if (numbers[mid] < target) {
                hi = mid;
            } else {
                hi --;
            }
        }
        return numbers[hi + 1];
    }
}
