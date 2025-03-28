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
    public int goodNodes(TreeNode root) {
        int[] ans = new int[1];
        int max = root.val;
        goodNodesUtil(root,ans,max);
        return ans[0];
    }

    public void goodNodesUtil(TreeNode root, int[]ans,int max) {
        if(root==null)
            return;
        // int temp = max;    
        if(root.val>=max){
            max=root.val;
            ans[0]++;
        }
        goodNodesUtil(root.left,ans,max);
        //  max = temp;
        goodNodesUtil(root.right,ans,max);
        // max = temp;


    }
}