package algorithm.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProblemNo8 {

    @Test
    void test() {
        assertThat(myAtoi("42")).isEqualTo(42);
        assertThat(myAtoi("    -42")).isEqualTo(-42);
        assertThat(myAtoi("4193 with words")).isEqualTo(4193);
        assertThat(myAtoi("words with 4193")).isEqualTo(0);
        assertThat(myAtoi("-91283472332")).isEqualTo(Integer.MIN_VALUE);
        assertThat(myAtoi("")).isEqualTo(0);
        assertThat(myAtoi("9223372036854775808")).isEqualTo(Integer.MAX_VALUE);
    }

    private int myAtoi(String s) {
        int num = 0;
        int i = 0, sign = 1;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i++) == '-' ? -1 : 1;
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            if (num > Integer.MAX_VALUE / 10 ||
                     (num == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
             return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + (s.charAt(i++) - '0');
        }
        return num * sign;
    }
}
