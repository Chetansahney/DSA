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
    public int[] findMode(TreeNode root) 
    {
        HashMap<Integer,Integer > counter=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode temp=q.remove();
            counter.put(temp.val, counter.getOrDefault(temp.val, 0) + 1);

            if(temp.left!=null)
            q.add(temp.left);

            if(temp.right!=null)
            q.add(temp.right);

        }
      int maxFreq = 0;
        for (int key : counter.keySet()) {
            maxFreq = Math.max(maxFreq, counter.get(key));
        }
        
        List<Integer> ans = new ArrayList();
        for (int key : counter.keySet()) {
            if (counter.get(key) == maxFreq) {
                ans.add(key);
            }
        }
        
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        
        return result;
    }
}