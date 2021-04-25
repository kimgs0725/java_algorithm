package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ProblemNo22 {

    @Test
    void test() {
        List<String> strings = generateParenthesis(3);
        for (String string : strings) {
            System.out.println("string = " + string);
        }
    }

    private List<String> generateParenthesis(int n) {
        // 백트래킹을 사용 or 스택 사용
        List<String> output = new ArrayList<>();
        makeParenthesis(output, new StringBuilder(""), n, n);
        return output;
    }

    private void makeParenthesis(List<String> output, StringBuilder parenthesis, int open, int close) {
        if (open == 0 && close == 0) {
            output.add(parenthesis.toString());
            return;
        }
        if (open > close) {
            return;
        }
        if (open > 0) {
            makeParenthesis(output, parenthesis.append('('), open - 1, close);
            parenthesis.deleteCharAt(parenthesis.length() - 1);
        }
        makeParenthesis(output, parenthesis.append(')'), open, close - 1);
        parenthesis.deleteCharAt(parenthesis.length() - 1);
    }
}
