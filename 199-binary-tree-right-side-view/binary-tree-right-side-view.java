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
    public List<Integer> rightSideView(TreeNode root) {
        Queue <TreeNode> q=new LinkedList<>();
        List<Integer> view= new ArrayList<>();
        if(root==null)return view;
        q.offer(root);
        while(!q.isEmpty())
        {
            int size=q.size();TreeNode node =null;
            while(size-->0)
            {
                node=q.poll();
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            view.add(node.val);
        }
        return view;
    }

}