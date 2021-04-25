package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProblemNo78 {

    @Test
    void test() {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        for (List<Integer> subset : subsets) {
            StringBuilder bitmask = new StringBuilder();
            for (Integer integer : subset) {
                bitmask.append(integer);
            }
            System.out.println(bitmask.toString());
        }
    }

    private List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        subsets(nums, 0, ans, new LinkedList<Integer>(), nums.length);
        ans.addLast(new LinkedList<Integer>());
        return ans;
    }

    private void subsets(int[] nums, int index, LinkedList<List<Integer>> ans, LinkedList<Integer> temp, int length) {
        if (index >= length) {
            return;
        }
        subsets(nums, index + 1, ans, new LinkedList<Integer>(temp), length);
        temp.addLast(nums[index]);
        ans.addLast(new LinkedList<Integer>(temp));
        subsets(nums, index + 1, ans, new LinkedList<Integer>(temp), length);
    }
    // private List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> output = new ArrayList<>();
    //     int n = nums.length;

    //     for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n+1); i++) {
    //         String bitmask = Integer.toBinaryString(i).substring(1);
    //         System.out.println("bitmask = " + bitmask);
    //         List<Integer> curr = new ArrayList<>();
    //         for (int j = 0; j < n; j++) {
    //             if (bitmask.charAt(j) == '1') {
    //                 curr.add(nums[j]);
    //             }
    //         }
    //         output.add(curr);
    //     }
    //     return output;
    // }
}
