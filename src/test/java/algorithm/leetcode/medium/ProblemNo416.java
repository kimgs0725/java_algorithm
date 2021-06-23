package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo416 {

    @Test
    void test() {
        assertThat(canPartition(new int[]{1, 2, 5})).isFalse();
        assertThat(canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100}))
                .isTrue();
    }

    private boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        boolean[][] B = new boolean[nums.length][sum / 2 + 1];
        if (nums[0] <= sum / 2) {
            B[0][nums[0]] = true;
        }
        for (int i = 0; i < nums.length; i++) {
            B[i][0] = true;
        }

        for (int i = 1; i < B.length; i++) {
            for (int j = 1; j < B[0].length; j++) {
                if (j < nums[i]) {
                    B[i][j] = B[i - 1][j];
                } else {
                    B[i][j] = B[i - 1][j] || B[i - 1][j - nums[i]];
                }
            }
        }
        return B[B.length - 1][B[0].length - 1];
    }
}
