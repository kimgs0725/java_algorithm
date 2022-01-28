package algorithm.codility;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo3 {

    @Test
    void test() {
        assertThat(solution(new int[]{-3, -2, 1, 0, 8, 7, 1}, 3)).isEqualTo(4);
        assertThat(solution(new int[]{7, 1, 11, 8, 4, 10}, 8)).isEqualTo(1);
    }

    public int solution(int[] A, int M) {
        List<List<Integer>> subsets = new ArrayList<>();
        for (int i : A) {
            boolean has_subset = false;
            for (List<Integer> subset : subsets) {
                if (Math.abs(subset.get(subset.size() - 1) - i) % M == 0) {
                    subset.add(i);
                    has_subset = true;
                }
            }
            if (!has_subset) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                subsets.add(tmp);
            }
        }
        int max = -1;
        for (List<Integer> subset : subsets) {
            max = Math.max(max, subset.size());
        }
        return max;
    }
}
