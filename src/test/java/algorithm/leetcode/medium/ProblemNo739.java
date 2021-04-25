package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ProblemNo739 {

    @Test
    void test() {
        int[] ret = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i : ret) {
            System.out.println("i = " + i);
        }
    }

    private int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()])
                stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
