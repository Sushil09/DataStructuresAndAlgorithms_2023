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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = findLCA(root,startValue,destValue);
        StringBuilder rootToSrc = new StringBuilder();
        StringBuilder rootToDes = new StringBuilder();
        populateSrc(LCA,startValue,rootToSrc);
        populateSrc(LCA,destValue,rootToDes);

        StringBuilder ans = new StringBuilder();
        for(int i=0;i<rootToSrc.length();i++){
            ans.append("U");
        }
        return ans.append(rootToDes).toString();
    }

    private static boolean populateSrc(TreeNode root, int startValue,StringBuilder rootToSrc) {
        if(root==null )
            return false;
        if(root.val==startValue)
            return true;
        rootToSrc.append("L");

        if(populateSrc(root.left,startValue,rootToSrc))
            return true;
        rootToSrc.deleteCharAt(rootToSrc.length() - 1);  

        rootToSrc.append("R");

        if(populateSrc(root.right,startValue,rootToSrc))
            return true;
        rootToSrc.deleteCharAt(rootToSrc.length() - 1);  
        return false;
    } 

    // private static void populateDes(TreeNode root, int destValue,StringBuilder rootToDes) {
    //     if(root==null || root.val==destValue)
    //         return;
    //     populateDes(root.left,startValue,rootToSrc.append("L"));
    //     populateDes(root.right,startValue,rootToSrc.append("R"));
    // } 

    private static TreeNode findLCA(TreeNode root, int startValue, int destValue) {
        if(root==null || root.val == startValue || root.val == destValue)
            return root;
        
        TreeNode left = findLCA(root.left,startValue,destValue);
        TreeNode right = findLCA(root.right,startValue,destValue);

        if(left != null && right != null)
            return root;
        return left ==null?right:left;    
    }
}