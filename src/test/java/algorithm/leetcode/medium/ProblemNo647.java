package algorithm.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProblemNo647 {

    @Test
    void test() {
        assertThat(countSubstrings("abc")).isEqualTo(3);
        assertThat(countSubstrings("aaa")).isEqualTo(6);
    }

    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;

        if (n <= 0) {
            return 0;
        }

        boolean[][] dp = new boolean[n][n];

        // base case: 1 character
        for (int i = 0; i < n; i++, ans++) {
            dp[i][i] = true;
        }

        // base case: 2 character
        for (int i = 0; i < n - 1; i++) {
            dp[i][i+1] = (s.charAt(i) == s.charAt(i+1));
            ans += (dp[i][i+1] ? 1 : 0);
        }

        // a'dp[i+1][j-1]'a = true
        // a'dp[i+1][j-1]'b = false
        for (int len = 3; len <= n; len++) {
            for (int i = 0, j = i + len - 1; j < n; i++, j++) {
                dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                ans += (dp[i][j] ? 1 : 0);
            }
        }

        return ans;
    }
}
