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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) 
    {
        List<TreeNode> list=new ArrayList<>();
        solve(root,new HashMap<>(),list);
        return list;
    }
    public String solve(TreeNode root, Map<String,Integer> map,List<TreeNode> list)
    {
        if(root==null)return "#";

        String s=root.val+","+solve(root.left,map,list)+","+solve(root.right,map,list);
        map.put(s,map.getOrDefault(s,0)+1);
        if(map.get(s)==2)list.add(root);
        return s;
    }
}