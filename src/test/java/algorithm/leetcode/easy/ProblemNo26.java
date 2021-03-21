package algorithm.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProblemNo26 {

    @Test
    void test() {
        assertThat(removeDuplicates(new int[]{1, 1, 2})).isEqualTo(2);
        assertThat(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4})).isEqualTo(5);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}
