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
    public boolean isValidBST(TreeNode root) {
        return validateBst(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private static boolean validateBst(TreeNode root,long low,long high) {
        if(root==null) 
            return true;

        return  (root.val>low  && root.val<high) &&
                validateBst(root.left,low,root.val) &&
                validateBst(root.right,root.val,high);
    }

}
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return validateBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }

//     private boolean validateBst(TreeNode root, long low, long high) {
//         if (root == null) return true;

//         if (root.val <= low || root.val >= high) return false;

//         return validateBst(root.left, low, root.val) &&
//                validateBst(root.right, root.val, high);
//     }
// }
