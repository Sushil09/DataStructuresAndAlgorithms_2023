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
    public int maxPathSum(TreeNode root) {
        int[]maxSum = new int[1];
        maxSum[0]=Integer.MIN_VALUE/2;
        if(root.left == null && root.right==null)
            return root.val;

        int sum = maxPath(root,maxSum);
        return Math.max(maxSum[0],sum);
    }
    private static int maxPath(TreeNode root, int[]ans) {
        if(root==null)
            return 0;

        int left = Math.max(0,maxPath(root.left,ans));
        int right = Math.max(0,maxPath(root.right,ans));
        int sumAtNode = root.val+left+right;

        ans[0]=Math.max(ans[0],sumAtNode);

        return root.val+Math.max(left,right);        
    }
}