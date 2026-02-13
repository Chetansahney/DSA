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
    HashMap<Integer,Integer> map=new HashMap<>();
    int max=0;
    public int subtreesum(TreeNode root)
    {
        if(root==null)return 0;
        int leftsubtree= subtreesum(root.left);
        int rightsubtree= subtreesum(root.right);
        int currsum=root.val+leftsubtree+rightsubtree;

        map.put(currsum, map.getOrDefault(currsum, 0) + 1);
        max=Math.max(max,map.get(currsum));
        return currsum;
    }
    public int[] findFrequentTreeSum(TreeNode root) 
    {
        subtreesum(root);
        List <Integer> list=new ArrayList<>();
        for(int key: map.keySet())
        {
            int freq=map.get(key);
            if(freq==max)list.add(key);

        }
        int maxFreqSums[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            maxFreqSums[i] =  list.get(i);
        }
        
        return maxFreqSums;
    }
}