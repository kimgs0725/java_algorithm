package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo406 {

    @Test
    void test() {
        int[][] ret = reconstructQueue(new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        });
        assertThat(ret[0][0]).isEqualTo(5);
        assertThat(ret[0][1]).isEqualTo(0);
    }

    private int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (c1, c2) -> {
            if (c1[0] == c2[0]) {
                return c1[1] - c2[1];
            }
            return c2[0] - c1[0];
        });
        List<int[]> res = new ArrayList<>();
        for (int[] person : people) {
            res.add(person[1], person);
        }
        return res.toArray(new int[1][1]);
    }
}
