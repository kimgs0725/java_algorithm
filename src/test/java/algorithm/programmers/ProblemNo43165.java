package algorithm.programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProblemNo43165 {
    private int answer = 0;

    @Test
    void test() {
        assertThat(solution(new int[]{1, 1, 1, 1, 1}, 3)).isEqualTo(5);
    }

    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }

    private void dfs(int idx, int sum, int[] numbers, int target) {
        if (idx == numbers.length) {
            answer += (sum == target ? 1 : 0);
            return;
        }

        for (int i = idx; i < numbers.length; i++) {
            dfs(i + 1, sum + numbers[i], numbers, target);
            dfs(i + 1, sum - numbers[i], numbers, target);
        }
    }
}
