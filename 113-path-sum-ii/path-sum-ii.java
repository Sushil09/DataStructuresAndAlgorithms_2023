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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        populatePathSum(root,targetSum,ans, new ArrayList<>());
        return ans;
    }

    private void populatePathSum(TreeNode root, int K,List<List<Integer>> ans, List<Integer> temp) {
        if(root==null)
            return;
        if(isLeaf(root)){
            if(root.val == K) {
            temp.add(root.val);
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
        }   
            return;
        }
        temp.add(root.val);    
        populatePathSum(root.left,K-root.val,ans,temp);
        populatePathSum(root.right,K-root.val,ans,temp);
        temp.remove(temp.size()-1);   
    }

    private boolean isLeaf(TreeNode root) {
        return root.left ==null &&  root.right == null;
    }
}