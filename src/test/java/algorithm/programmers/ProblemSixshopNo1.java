package algorithm.programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProblemSixshopNo1 {

    @Test
    void test() {
        assertThat(solution(new int[]{5, 1, 9, 8, 10, 5}, 3)).isEqualTo(27);
        assertThat(solution(new int[]{10, 1, 10, 1, 1, 4, 3, 10}, 6)).isEqualTo(29);
    }

    public int solution(int[] estimates, int k) {
        int max = 0, n = estimates.length, currentTotal = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                currentTotal -= estimates[i - k];
            }
            currentTotal += estimates[i];
            max = Math.max(max, currentTotal);
        }
        return max;
    }
}
