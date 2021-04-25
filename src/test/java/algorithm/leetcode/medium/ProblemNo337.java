package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo337 {

    private int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // reform tree into array-based tree
        ArrayList<Integer> tree = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        graph.put(-1, new ArrayList<>());
        int index = -1;
        // we use two Queue to store node and index
        Queue<TreeNode> q_node = new LinkedList<>();
        q_node.add(root);
        Queue<Integer> q_index = new LinkedList<>();
        q_index.add(index);

        while (q_node.size() > 0) {
            TreeNode node = q_node.poll();
            int parentIndex = q_index.poll();
            if (node != null) {
                index++;
                tree.add(node.val);
                graph.put(index, new ArrayList<>());
                graph.get(parentIndex).add(index);
                // push new node into Queue
                q_node.add(node.left);
                q_index.add(index);
                q_node.add(node.right);
                q_index.add(index);
            }
        }

        // represent the maximum start by node i with robbing i
        int[] dpRob = new int[index + 1];

        // represent the maximum start by node i without robbing i
        int[] dpNotRob = new int[index + 1];

        for (int i = index; i >= 0; i--) {
            ArrayList<Integer> children = graph.get(i);
            if (children == null || children.size() == 0) {
                // if is leaf
                dpRob[i] = tree.get(i);
                dpNotRob[i] = 0;
            } else {
                dpRob[i] = tree.get(i);
                for (int child : children) {
                    dpRob[i] += dpNotRob[child];
                    dpNotRob[i] += Math.max(dpRob[child], dpNotRob[child]);
                }
            }
        }

        return Math.max(dpRob[0], dpNotRob[0]);
    }

    // HashMap<TreeNode, Integer> robResult = new HashMap<>();
    // HashMap<TreeNode, Integer> notRobResult = new HashMap<>();
    // public int helper(TreeNode node, boolean parentRobbed) {
    //     if (node == null) {
    //         return 0;
    //     }
    //     if (parentRobbed) {
    //         if (robResult.containsKey(node)) {
    //             return robResult.get(node);
    //         }
    //         int result = helper(node.left, false) + helper(node.right, false);
    //         robResult.put(node, result);
    //         return result;
    //     } else {
    //         if (notRobResult.containsKey(node)) {
    //             return notRobResult.get(node);
    //         }
    //         int rob = node.val + helper(node.left, true) + helper(node.right, true);
    //         int notRob = helper(node.left, false) + helper(node.right, false);
    //         int result = Math.max(rob, notRob);
    //         notRobResult.put(node, result);
    //         return result;
    //     }
    // }

    // public int rob(TreeNode root) {
    //     return helper(root, false);
    // }

    // public int rob(TreeNode root) {
    //     if (root == null) return 0;
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     int amount1 = 0, amount2 = 0;
    //     queue.add(root);
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         boolean is_amount1 = true;
    //         for (int i = 0; i < size; i++) {
    //             TreeNode node = queue.poll();
    //             if (node.left != null) {
    //                 queue.offer(node.left);
    //             }
    //             if (node.right != null) {
    //                 queue.offer(node.right);
    //             }
    //             if (is_amount1) {
    //                 amount1 += node.val;
    //             } else {
    //                 amount2 += node.val;
    //             }
    //         }
    //         is_amount1 = !is_amount1;
    //     }
    //     return Math.max(amount1, amount2);
    // }

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
