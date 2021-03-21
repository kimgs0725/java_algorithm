package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo11 {
    @Test
    void test() {
        assertThat(maxArea(new int[]{1,8,6,2,5,4,8,3,7})).isEqualTo(49);
        assertThat(maxArea(new int[]{1,1})).isEqualTo(1);
        assertThat(maxArea(new int[]{1,2,1})).isEqualTo(2);
        assertThat(maxArea(new int[]{4,3,2,1,4})).isEqualTo(16);
    }

    private int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return area;
    }
}
