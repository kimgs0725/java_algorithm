package algorithm.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class ProblemNo17 {

    @Test
    void test() {
        assertThat(letterCombinations3("23")).contains("ad", "ae", "af");
    }

    private Map<Character, List<Character>> digitToAlpha;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        init();
        List<String> ans = new ArrayList<>();
        combinationString(digitToAlpha, digits, 0, ans, new StringBuilder());
        return ans;
    }

    void combinationString(Map<Character, List<Character>> digitToAlpha, String digits, int index, List<String> comb, StringBuilder s) {
        if (index == digits.length()) {
            comb.add(s.toString());
            return;
        }
        List<Character> alpha = digitToAlpha.get(digits.charAt(index));
        for (int i = 0; i < alpha.size(); i++) {
            s.append(alpha.get(i));
            combinationString(digitToAlpha, digits, index + 1, comb, s);
            s.deleteCharAt(s.length() - 1);
        }
    }

    private void init() {
        digitToAlpha = new HashMap<>();
        digitToAlpha.put('2', Arrays.asList('a', 'b', 'c'));
        digitToAlpha.put('3', Arrays.asList('d', 'e', 'f'));
        digitToAlpha.put('4', Arrays.asList('g', 'h', 'i'));
        digitToAlpha.put('5', Arrays.asList('j', 'k', 'l'));
        digitToAlpha.put('6', Arrays.asList('m', 'n', 'o'));
        digitToAlpha.put('7', Arrays.asList('p', 'q', 'r', 's'));
        digitToAlpha.put('8', Arrays.asList('t', 'u', 'v'));
        digitToAlpha.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while (ans.peek().length() != digits.length()){
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for(char c: map.toCharArray()){
                ans.addLast(remove + c);
            }
        }
        return ans;
    }

    public List<String> letterCombinations3(String digits) {
        LinkedList<StringBuilder> ans = new LinkedList<>();
        if (digits.isEmpty()) {
            return ans.stream().map(StringBuilder::toString).collect(Collectors.toList());
        }
        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder empty = new StringBuilder();
        empty.setLength(0);
        ans.add(empty);
        while (ans.peek().length() != digits.length()){
            StringBuilder remove = ans.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for(char c: map.toCharArray()){
                ans.addLast(new StringBuilder(remove).append(c));
            }
        }
        return ans.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }
}
