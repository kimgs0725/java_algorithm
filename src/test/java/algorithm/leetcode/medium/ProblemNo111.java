package algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ProblemNo111 {

    public int minDepth(TreeNode root) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : freq.entrySet()) {
            integerIntegerEntry.getValue();
        }
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode rt = queue.peek();
                queue.offer(rt.left);
                queue.offer(rt.right);
                queue.poll();
                if (rt.left == null && rt.right == null) {
                    return depth;
                }
            }
        }
        return -1;
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
