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
    int min;
    long secondmin=Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        min = root.val;
        dfs(root);
        return secondmin == Long.MAX_VALUE ? -1 : (int)secondmin;
        
    }
    private void dfs(TreeNode node)
    {
        if(node==null)
        return;
        if(node.val>min && node.val<secondmin)
        secondmin=node.val;

        dfs(node.left);
        dfs(node.right);
    }
}