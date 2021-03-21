package algorithm.scf;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo2 {

    @Test
    void test() {
        assertThat(findNumberOfArrived(3, new int[]{1, 1, 1})).isEqualTo(2);
        assertThat(findNumberOfArrived(4, new int[]{1, 1, 0, 1})).isEqualTo(1);
        assertThat(findNumberOfArrived(5, new int[]{1, 1, 1, 1, 1})).isEqualTo(5);
        assertThat(findNumberOfArrived(12, new int[]{1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1})).isEqualTo(5);
        assertThat(findNumberOfArrived(50, new int[]{
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        })).isEqualTo(12586269025L);
    }

    private long findNumberOfArrived(int n, int[] node) {
        long[] mem = new long[n];
        mem[0] = 1;
        mem[1] = node[1] == 0 ? 0 : 1;
        for (int i = 2; i < n; i++) {
            mem[i] = node[i] == 0 ? 0 : mem[i-1] + mem[i-2];
        }
        return mem[n-1];
    }
}
