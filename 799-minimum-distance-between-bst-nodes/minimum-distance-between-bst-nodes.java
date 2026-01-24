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
    int ans=Integer.MAX_VALUE;int res=Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) 
    {
        inorder(root);
        return ans;
    }
    public void inorder(TreeNode root)
    {
        if(root==null)
        return;

        inorder(root.left);
        ans=Math.min(ans,Math.abs(root.val-res));
        res=root.val;
        inorder(root.right);


    }
}