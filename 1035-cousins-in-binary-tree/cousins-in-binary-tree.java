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
    //use bfs so that we search at the same depth
    public boolean isCousins(TreeNode root, int x, int y) 
    {
       if(root==null)return false;
       Queue<TreeNode> q=new LinkedList<>();
       q.offer(root);
       while(!q.isEmpty())//bfs code
       {
        int size=q.size();
        boolean a=false;
        boolean b=false;
        for(int i=0;i<size;i++)//iterating in queue
        {
            TreeNode curr=q.poll();
            if(curr.val==x)a=true;
            if(curr.val==y)b=true;
            if (curr.left != null && curr.right != null) { //same parent checking
				if (curr.left.val == x && curr.right.val == y) { 
					return false;
				}
				if (curr.left.val == y && curr.right.val == x) { 
					return false;
				}
			}
            if(curr.left!=null)q.offer(curr.left);if(curr.right!=null)q.offer(curr.right);
        }
        if(a&&b)return true;   
       }
       return false;
        



        } 
    }
