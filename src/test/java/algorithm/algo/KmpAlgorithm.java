package algorithm.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KmpAlgorithm {
    @Test
    void test() {
        assertThat(kmpSearch("aababbaabd", "abba")).isEqualTo(3);
        assertThat(kmpSearch("abcdefg", "ijk")).isEqualTo(-1);
    }

    int kmpSearch(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        int[] pi = getPartialMatch(needle);
        int begin = 0, matched = 0;
        while (begin <= n - m) {
            if (matched < m && haystack.charAt(begin + matched) == needle.charAt(matched)) {
                matched++;
                if (matched == m) {
                    return begin;
                }
            } else {
                if (matched == 0) {
                    begin++;
                } else {
                    begin += matched - pi[matched - 1];
                    matched = pi[matched-1];
                }
            }
        }
        return -1;
    }

    int[] getPartialMatchNative(String needle) {
        int m = needle.length();
        int[] pi = new int[m];
        for (int begin = 1; begin < m; begin++) {
            for (int i = 0; i < m; i++) {
                if (needle.charAt(begin + i) != needle.charAt(i)) {
                    break;
                }
                pi[begin + i] = Math.max(pi[begin + i], i + 1);
            }
        }
        return pi;
    }

    int[] getPartialMatch(String needle) {
        int m = needle.length();
        int[] pi = new int[m];
        int begin = 1, matched = 0;
        while (begin + matched < m) {
            if (needle.charAt(begin + matched) == needle.charAt(matched)) {
                matched++;
                pi[begin + matched - 1] = matched;
            } else {
                if (matched == 0) {
                    begin++;
                } else {
                    begin += matched - pi[matched-1];
                    matched = pi[matched-1];
                }
            }
        }
        return pi;
    }
}
