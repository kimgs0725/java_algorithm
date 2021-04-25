package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

public class ProblemNo238 {

    @Test
    void test() {
        int[] ret1 = productExceptSelf(new int[]{1, 2, 3, 4});
        for (int i : ret1) {
            System.out.println("i = " + i);
        }
        System.out.println("================");
        int[] ret2 = productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        for (int i : ret2) {
            System.out.println("i = " + i);
        }
    }

    private int[] productExceptSelf(int[] nums) {
        int zero_index = -1, zero_count = 0, product = 1;
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zero_count > 1) {
                    return ret;
                }
                zero_index = i;
                zero_count++;
            } else {
                product *= nums[i];
            }
        }

        if (zero_count == 1) {
            ret[zero_index] = product;
            return ret;
        }

        for (int i = 0; i < nums.length; i++) {
            ret[i] = product / nums[i];
        }
        return ret;
    }
}
