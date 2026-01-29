/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) 
    {
        dfs(original,cloned,target);return ans;
    }
    public void dfs(TreeNode a, TreeNode b,TreeNode target)
    {
        if(a==null)return;
        if(a!=null)
        {
            dfs(a.left,b.left,target);
            if(a==target)ans=b;
            dfs(a.right,b.right,target);
        }
    }
}