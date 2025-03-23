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
        TreeNode  ans = new TreeNode(Integer.MIN_VALUE);    
        int temp= maxPathSumUtil(root,ans);
        int finalAns = ans.val;
        ans = new TreeNode(Integer.MIN_VALUE);
        return finalAns;
    }

    private static int maxPathSumUtil(TreeNode root, TreeNode ans) {
        if(root==null)
            return 0;
        int leftSum = Math.max(0,maxPathSumUtil(root.left,ans));
        int rightSum = Math.max(0,maxPathSumUtil(root.right,ans));    
        int tempSum = Math.max(root.val,Math.max(leftSum,rightSum)+root.val);
        ans.val = Math.max(ans.val,rightSum+leftSum +root.val);
        return tempSum;
    }
}