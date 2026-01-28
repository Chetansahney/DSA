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
    //first check the left values the =n come to right one by one
    public boolean isUnivalTree(TreeNode root) 
    {
        boolean lc=(root.left==null||root.val==root.left.val&&isUnivalTree(root.left));//left left left left
        boolean rc=(root.right==null||root.val==root.right.val&&isUnivalTree(root.right));//right right right 
        return lc&&rc;
    }
}