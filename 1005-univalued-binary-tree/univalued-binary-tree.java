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
    public boolean isUnivalTree(TreeNode root) {
        return checkUnival(root);
    }

    private static boolean checkUnival(TreeNode root) {
        if(root==null)
            return true;
        boolean left = checkUnival(root.left);
        boolean right = checkUnival(root.right);

        boolean check = true;
        if(root.left!=null)
            check = (check && root.val == root.left.val);

        if(root.right!=null)
            check = (check && root.val == root.right.val);
        return check && left && right;        
    }
}