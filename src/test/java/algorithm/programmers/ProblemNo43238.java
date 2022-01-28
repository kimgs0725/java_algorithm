package algorithm.programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class ProblemNo43238 {

    @Test
    void test() {
        assertThat(solution(6, new int[]{7, 10})).isEqualTo(28);
    }

    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long low = 0, high = (long) n * times[times.length - 1];
        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }
            if (sum < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
