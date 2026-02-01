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
    public List<List<Integer>> levelOrderBottom(TreeNode root) 
    { List<List<Integer>> list=new ArrayList<>();
      if(root==null)return list;  

      Queue<TreeNode> q=new LinkedList<>();
      q.offer(root);
      while(!q.isEmpty())
      {
        List<Integer> level=new ArrayList<>();
        int size=q.size();
        for(int i=0;i<size;i++)
        {
            TreeNode head=q.poll();
            level.add(head.val);
            if(head.left!=null)q.offer(head.left);
            if(head.right!=null)q.offer(head.right);
        }
        list.add(0,level);// yahi pe change hai sirf, rest is same level order traversal code
      }
      return list;
    }
}