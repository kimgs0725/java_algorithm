package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo12 {

    @Test
    void test() {
        assertThat(intToRoman(3)).isEqualTo("III");
        assertThat(intToRoman(4)).isEqualTo("IX");
    }

    private String intToRoman(int num) {
        StringBuffer buffer = new StringBuffer();
        int[] values = {1000, 500, 100, 50, 10, 5, 1};
        char[] symbols = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        for (int i = 0; i < values.length; i++) {
            if (num >= values[i]) {
                int cnt = num / values[i];
                while (cnt-- > 0) {
                    buffer.append(symbols[i]);
                }
                num %= values[i];
            }
        }
        return buffer.toString();
    }
}
