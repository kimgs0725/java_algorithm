package algorithm.scf;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class TestNo2 {

    @Test
    void test() {
        assertThat(getBeverage2(12, 0)).isEqualTo(1);
        assertThat(getBeverage2(10, 14)).isEqualTo(2);
        assertThat(getBeverage2(4, 20)).isEqualTo(0);
        assertThat(getBeverage2(5, 2147483648L)).isEqualTo(1);
        assertThat(getBeverage2(21, 24)).isEqualTo(3);
    }

    private int getBeverage2(long n, long m) {
        int cnt = (int) Math.min(n / 5, m / 7);
        n -= cnt * 5L;
        m -= cnt * 7L;
        if (n < 5 || n + m < 12) {
            return cnt;
        }
        n -= (5 + (7-m));
        cnt++;
        cnt += (n / 12);
        return cnt;
    }
}
