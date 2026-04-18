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
        findPathSum(root,ans, new ArrayList<>(),targetSum);
        return ans;
    }

    public void findPathSum(TreeNode root, List<List<Integer>> ans, List<Integer> temp, int K) {
        if(root==null)
            return;
        
        temp.add(root.val);
        if(root.left==null && root.right == null && K == root.val) {
                ans.add(new ArrayList<>(temp));
        }
            else{
            findPathSum(root.left,ans,temp,K-root.val);
            findPathSum(root.right,ans,temp,K-root.val);
            }
     temp.remove(temp.size()-1);

    }
}