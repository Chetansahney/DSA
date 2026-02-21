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
    TreeNode helper(TreeNode root, Set<Integer> set,List<TreeNode> list)
    {
        if(root==null)return null;

        root.left=helper(root.left,set,list);
        root.right=helper(root.right,set,list);

        if(set.contains(root.val))
        {
            if(root.left!=null)list.add(root.left);
            if(root.right!=null)list.add(root.right);

            return null;

        }
        else
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) 
    {
       Set <Integer> set=new HashSet<>();
       for(int num:to_delete)
       {
        set.add(num);
       } 
       List<TreeNode> list=new ArrayList<>();
       root = helper(root, set, list);
       if (root != null) list.add(root);
       return list;

    }
}