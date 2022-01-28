package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo34 {

    @Test
    void test() {
        assertThat(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)).contains(3, 4);
        assertThat(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)).contains(-1, -1);
        assertThat(searchRange(new int[]{}, 0)).contains(-1, -1);
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{lowerBound(nums, target), upperBound(nums, target)};
    }

    private int lowerBound(int[] array, int value) {
        int idx = -1;
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            if (array[mid] == value) {
                idx = mid;
            }
        }
        return idx;
    }

    private int upperBound(int[] array, int value) {
        int idx = -1;
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            if (array[mid] == value) {
                idx = mid;
            }
        }
        return idx;
    }
}
