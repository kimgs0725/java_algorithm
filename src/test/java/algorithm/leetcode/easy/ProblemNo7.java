package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo7 {

    @Test
    void test() {
        assertThat(reverse(123)).isEqualTo(321);
        assertThat(reverse(-123)).isEqualTo(-321);
        assertThat(reverse(120)).isEqualTo(21);
        assertThat(reverse(0)).isEqualTo(0);
        assertThat(reverse(1534236469)).isEqualTo(0);
    }

    public int reverse(int x) {
        long ret = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while (x != 0) {
            ret *= 10;
            ret += x % 10;
            if (min > ret || ret > max) {
                return 0;
            }
            x /= 10;
        }

        return (int) ret;
    }
}
