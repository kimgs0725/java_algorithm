package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ProblemNo496 {

    @Test
    void test() {
        int[] ret = nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        for (int i : ret) {
            System.out.println("i = " + i);
        }
    }

    private int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int[] greaterElement = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = greaterElement.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= nums2[stack.peek()])
                stack.pop();
            greaterElement[i] = stack.isEmpty() ? -1 : nums2[stack.peek()];
            stack.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = greaterElement[i];
        }
        return ans;
    }
}
