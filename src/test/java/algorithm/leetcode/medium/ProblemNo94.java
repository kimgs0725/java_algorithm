package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ProblemNo94 {

    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            output.add(curr.val);
            curr = curr.right;
        }
        return output;
    }
    // private List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> output = new ArrayList<>();
    //     traversal(root, output);
    //     return output;
    // }

    // private void traversal(TreeNode node, List<Integer> output) {
    //     if (node.left != null) {
    //         traversal(node.left, output);
    //     }
    //     output.add(node.val);
    //     if (node.right != null) {
    //         traversal(node.right, output);
    //     }
    // }
}

/**
 * Definition for a binary tree node.
 */
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

