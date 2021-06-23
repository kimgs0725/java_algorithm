package algorithm.leetcode.medium;

public class ProblemNo240 {
    private boolean searchMatrix(int[][] matrix, int target) {
        int y = 0, x = matrix[0].length - 1;
        while (y < matrix.length && x >= 0) {
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }
}
