package algorithm.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ProblemNo438 {

    @Test
    void test() {
        assertThat(findAnagrams("cbaebabacd", "abc")).contains(0, 6);
        assertThat(findAnagrams("abab", "ab")).contains(0, 1, 2);
    }

    private List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return list;
        }
        int[] hash = new int[256];
        for (char c : p.toCharArray()) {
            hash[c]++;
        }

        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- >= 1) {
                count--;
            }

            if (count == 0) {
                list.add(left);
            }

            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
                count++;
            }
        }

        return list;
    }
}
