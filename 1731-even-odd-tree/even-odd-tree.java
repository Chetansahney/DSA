/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    boolean helper(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (level % 2 == 0) {
                    if (node.val % 2 == 0 || node.val <= prev) {
                        return false;
                    }
                }

                else {
                    if (node.val % 2 != 0 || node.val >= prev) {
                        return false;
                    }
                }

                prev = node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            
            level++;
        }
        return true;
    }

    public boolean isEvenOddTree(TreeNode root) {
        return helper(root);
    }
}