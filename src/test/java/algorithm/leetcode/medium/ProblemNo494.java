package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo494 {

    @Test
    void test() {
        assertThat(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3)).isEqualTo(5);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return findSumWay(nums, 0, target, 0);
    }

    private int findSumWay(int[] nums, int index, int target, int sum) {
        if (index == nums.length) {
            return target == sum ? 1 : 0;
        }

        return findSumWay(nums, index + 1, target, sum + nums[index])
                + findSumWay(nums, index + 1, target, sum - nums[index]);
    }
}
