package algorithm.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.*;

public class ProblemNo378 {

    @Test
    void test() {
        assertThat(kthSmallest(new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        }, 8)).isEqualTo(13);
        assertThat(kthSmallest(new int[][]{
                {-5}
        }, 1)).isEqualTo(-5);
    }

    // public int kthSmallest(int[][] matrix, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();
    //     for (int y = 0; y < matrix.length; y++) {
    //         for (int x = 0; x < matrix[0].length; x++) {
    //             pq.add(matrix[y][x]);
    //         }
    //     }

    //     int numberCount = 0, ans = -1;
    //     while (!pq.isEmpty()) {
    //         ans = pq.poll();
    //         if (++numberCount == k) {
    //             break;
    //         }
    //     }
    //     return ans;
    // }

    public int kthSmallest(int[][] matrix, int k) {
       int n = matrix.length, lo = matrix[0][0], hi = matrix[n-1][n-1];

       while (lo <= hi) {
           int mi = lo + ((hi - lo) >> 1);
           int count = countNonBigger(mi, matrix);
           if (count < k) {
               lo = mi + 1;
           } else {
               hi = mi - 1;
           }
       }
       return lo;
    }

    private static int countNonBigger(int target, int[][] matrix) {
        int n = matrix.length, i = n - 1, j = 0, cnt = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > target) {
                i--;
            } else {
                cnt += (i + 1);
                j++;
            }
        }
        return cnt;
    }
}
