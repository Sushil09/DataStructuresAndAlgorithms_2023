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
    public int diameterOfBinaryTree(TreeNode root) {
        int[]diameter = new int[1];
        findMaxDiameter(root,diameter);
        return diameter[0];
    }

    private static int findMaxDiameter(TreeNode root,int[]diameter){
        if(root==null)
            return 0;
        
        int lH = findMaxDiameter(root.left,diameter);
        int rH = findMaxDiameter(root.right,diameter);

        diameter[0]=Math.max(diameter[0],lH+rH);
        return 1+Math.max(lH,rH);   
    }
}