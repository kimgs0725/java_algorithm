package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo20 {

    @Test
    void test() {
        assertThat(isValid("()")).isTrue();
        assertThat(isValid("(){}[]")).isTrue();
        assertThat(isValid("(]")).isFalse();
        assertThat(isValid("([)]")).isFalse();
        assertThat(isValid("{[]}()(")).isFalse();
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> mappingChar = new HashMap<>();
        mappingChar.put('(', ')');
        mappingChar.put('{', '}');
        mappingChar.put('[', ']');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character pop_c = stack.pop();
                if (mappingChar.get(pop_c) != c) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
