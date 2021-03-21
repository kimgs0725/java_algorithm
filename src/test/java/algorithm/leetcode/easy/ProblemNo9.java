package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo9 {

    @Test
    void test() {
        assertThat(isPalindrome(121)).isTrue();
        assertThat(isPalindrome(1212)).isFalse();
        assertThat(isPalindrome(-121)).isFalse();
        assertThat(isPalindrome(10)).isFalse();
        assertThat(isPalindrome(-101)).isFalse();
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String integer = Integer.toString(x);
        for (int i = 0; i < integer.length() / 2; i++) {
            if (integer.charAt(i) != integer.charAt(integer.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
