package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ProblemNo230 {
    private int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    private List<Integer> inorder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return arr;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
