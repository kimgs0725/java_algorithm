package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProblemNo14 {

    @Test
    void test() {
        assertThat(longestCommonPrefix(new String[]{"flower", "flow", "flight"})).isEqualTo("fl");
        assertThat(longestCommonPrefix(new String[]{"dog", "racecar", "car"})).isEqualTo("");
        assertThat(longestCommonPrefix(new String[]{})).isEqualTo("");
        assertThat(longestCommonPrefix(new String[]{"dog"})).isEqualTo("dog");
        assertThat(longestCommonPrefix(new String[]{"ab", "a"})).isEqualTo("a");
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder ret = new StringBuilder("");
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (str.length() <= i || c != str.charAt(i)) {
                    return ret.toString();
                }
            }
            ret.append(c);
        }
        return ret.toString();
    }
}
