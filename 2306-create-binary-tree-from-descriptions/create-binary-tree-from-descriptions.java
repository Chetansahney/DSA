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
    public TreeNode createBinaryTree(int[][] descriptions) 
    {
        Map<Integer,TreeNode> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();//stores the children and used to check ki konsi value hashset me and hashmap me hai, if value hashmap me hai and set me nahi hai, toh woh root hoega. and usko return karwadenge. kyuki set me saare children hi store kiye hai.
        for(int[] arr: descriptions)
        {
            int parent=arr[0];
            int child=arr[1];
            int isleft=arr[2];
            // create parent node if absent
            map.putIfAbsent(parent, new TreeNode(parent));

            // create child node if absent
            map.putIfAbsent(child, new TreeNode(child));

            if(isleft==1)
            {
                map.get(parent).left=map.get(child);
            }
            else
            map.get(parent).right=map.get(child);

            set.add(child);
        }
        for(int num[]:descriptions)
        {
            int parent=num[0];
            if(!set.contains(parent))
            return map.get(parent);
        }
        return null;

    }
}