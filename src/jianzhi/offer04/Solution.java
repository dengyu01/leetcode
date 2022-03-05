package jianzhi.offer04;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (target > matrix[i][j]) {
                i ++;
            } else if (target < matrix[i][j]) {
                j --;
            } else {
                return true;
            }
        }
        return false;
    }
}
