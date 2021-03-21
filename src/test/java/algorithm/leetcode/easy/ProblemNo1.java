package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo1 {

    @Test
    void test() {
        ProblemNo1 problemNo1 = new ProblemNo1();

        assertThat(problemNo1.twoSum(new int[]{2, 7, 11, 15}, 9)).contains(0, 1);
        assertThat(problemNo1.twoSum(new int[]{3, 2, 4}, 6)).contains(1, 2);
        assertThat(problemNo1.twoSum(new int[]{3, 3}, 6)).contains(0, 1);

        char[] s = new char[]{'a', 'b', 'c', 'd'};
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (prevMap.containsKey(diff)) {
                return new int[]{prevMap.get(diff), i};
            }
            prevMap.put(nums[i], i);
        }
        return new int[0];
    }
}
