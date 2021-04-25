package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProblemNo1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String haystack = br.readLine();
        String needle = br.readLine();
        List<Integer> ret = kmpSearch(haystack, needle);
        System.out.println(ret.size());
        for (Integer integer : ret) {
            System.out.print(integer + 1 + " ");
        }
    }

    private static List<Integer> kmpSearch(String haystack, String needle) {
        List<Integer> ret = new ArrayList<>();
        int n = haystack.length(), m = needle.length();
        int[] pi = getPartialMatch(needle);
        int begin = 0, matched = 0;
        while (begin <= n - m) {
            if (matched < m && haystack.charAt(begin + matched) == needle.charAt(matched)) {
                matched++;
                if (matched == m) {
                    ret.add(begin);
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
        return ret;
    }

    private static int[] getPartialMatch(String needle) {
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
