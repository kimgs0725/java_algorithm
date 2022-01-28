package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo45 {

    @Test
    void test() {
        assertThat(jump(new int[]{2,3,1,1,4})).isEqualTo(2);
        assertThat(jump(new int[]{2,3,0,1,4})).isEqualTo(2);
    }

    int jump(int nums[]) {
        int pos = nums.length - 1;
        int steps = 0;
        while (pos != 0) {
            for (int i = 0; i < pos; i++) {
                if (nums[i] >= pos - i) {
                    pos = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
