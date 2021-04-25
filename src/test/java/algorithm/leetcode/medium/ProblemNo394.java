package algorithm.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

public class ProblemNo394 {

    @Test
    void test() {
        assertThat(decodeSolution("3[a]2[bc]")).isEqualTo("aaabcbc");
        assertThat(decodeSolution("3[a2[c]]")).isEqualTo("accaccacc");
        assertThat(decodeSolution("2[abc]3[cd]ef")).isEqualTo("abcabccdcdcdef");
        assertThat(decodeSolution("abc3[cd]xyz")).isEqualTo("abccdcdcdxyz");
    }

    private String decodeSolution(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder tmp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    tmp.append(res);
                }
                res = tmp.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
