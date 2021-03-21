package algorithm.scf;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestNo1 {

    @Test
    void test() {
        assertThat(makeBlack(4, 3, new int[]{2, 3, 1, 4})).isEqualTo(2);
        assertThat(makeBlack(8, 3, new int[]{7, 3, 1, 8, 4, 6, 2, 5})).isEqualTo(4);
        assertThat(makeBlack(37, 4, new int[]{
                31, 36, 20, 30, 1, 9, 6, 13, 3, 29, 11, 25, 7, 8, 2, 24, 34, 18, 26, 15, 23, 28, 37, 19, 21, 4, 32, 14, 16, 10, 12, 27, 22, 35, 5, 17, 33
        })).isEqualTo(12);
    }

    private static int makeBlack(int n, int k, int[] arr) {
        int cnt = 0;
        for (int i = 0; i < n; i += (k - 1)) {
            if (i >= n - 1) {
                break;
            }
            cnt++;
        }
        return cnt;
    }
}
