package algorithm.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.*;

public class ProblemNo215 {

    @Test
    void test() {
        assertThat(findKthLargest(new int[]{3, 2,1 , 5, 6, 4}, 2)).isEqualTo(5);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return Integer.MAX_VALUE;
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private int findKthLargest(int[] nums, int start, int end, int k) {
        if (start > end)
            return Integer.MAX_VALUE;

        int pivot = nums[end];
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, left++, i);
            }
        }
        swap(nums, left, end);

        if (left == k)
            return nums[left];
        else if (left < k)
            return findKthLargest(nums, left + 1, end, k);
        else
            return findKthLargest(nums, start, left - 1, k);
    }

    void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    //public int findKthLargest(int[] nums, int k) {
    //    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    //    for (int n : nums) {
    //        pq.offer(n);
    //    }
    //    int ret = 0;
    //    while (k-- > 0) {
    //        ret = pq.poll();
    //    }
    //    return ret;
    //}
}
