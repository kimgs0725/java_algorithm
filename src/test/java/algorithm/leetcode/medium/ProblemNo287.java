package algorithm.leetcode.medium;

public class ProblemNo287 {

    private int findDuplicate(int[] nums) {
        boolean[] t = new boolean[30001];
        int ret = -1;
        for (int n : nums) {
            if (t[n]) {
                ret = n;
                break;
            }
            t[n] = true;
        }
        return ret;
    }
}
