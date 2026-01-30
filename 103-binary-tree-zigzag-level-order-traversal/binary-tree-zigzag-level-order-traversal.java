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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    { List<List<Integer>> list=new ArrayList<>();
      if(root==null)return list;
      Queue<TreeNode> q=new LinkedList<>();
      q.offer(root); boolean flag=true;
      while(!q.isEmpty())
      {
        int size=q.size();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            TreeNode node=q.poll();
            if(flag)
            {
                ans.add(node.val);

            }
            else
            {
                ans.add(0,node.val);
            }
            if(node.left!=null)q.offer(node.left);
            if(node.right!=null)q.offer(node.right);

        }
        list.add(ans);
        flag=!flag;//directly false nahi karsakte warna true kabhi hoega hi nahi

      } 
      return list;  
    }
}