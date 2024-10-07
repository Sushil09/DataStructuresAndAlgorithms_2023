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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return check(root,targetSum);
    }

    private static boolean check(TreeNode root, int K) {
        if(root == null)
            return false;
            
        if(root.left == null && root.right == null){
            return root.val == K;
        }

        return check(root.left, K - root.val) || check(root.right, K - root.val);
    }
}