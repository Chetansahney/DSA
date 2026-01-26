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
    int sum=0;
    public int findTilt(TreeNode root) 
    {
        int arr[]=new int[1];
        tilt(root,arr);
        return arr[0];
    }
    private int tilt(TreeNode root,int arr[])
    {
        if(root==null)
        return 0;

        int lv=tilt(root.left,arr);
        int rv=tilt(root.right,arr);
        arr[0]+=Math.abs(lv-rv);

        return  lv+rv+root.val;   
    }
}