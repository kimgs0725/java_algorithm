package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo29 {

    @Test
    void test() {
        assertThat(divide(-2147483648, -1)).isEqualTo(2147483647);
        assertThat(divide(10, 3)).isEqualTo(3);
        assertThat(divide(7, -3)).isEqualTo(-2);
        assertThat(divide(0, 1)).isEqualTo(0);
        assertThat(divide(1, 1)).isEqualTo(1);
    }

    int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0;
        for (int x = 31; x >= 0; x--) {
            if ((a >>> x) - b >= 0) {
                res += 1 << x;
                a -= b << x;
            }
        }
        return (A > 0) == (B > 0) ? res : -res;
    }
}
