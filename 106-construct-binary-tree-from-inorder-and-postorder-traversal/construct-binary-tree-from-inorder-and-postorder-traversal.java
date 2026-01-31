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
    int idx;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length - 1;

        // store inorder indices
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return solve(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode solve(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) return null;

        int rootVal = postorder[idx--];
        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);

        // build RIGHT first
        root.right = solve(inorder, postorder, mid + 1, end);
        root.left = solve(inorder, postorder, start, mid - 1);

        return root;
    }
}
