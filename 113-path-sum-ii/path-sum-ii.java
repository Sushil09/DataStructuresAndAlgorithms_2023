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
        populateNodes(root,ans,new ArrayList<>(),targetSum);
        return ans;
    }

    private static void populateNodes(TreeNode root, List<List<Integer>> ans, List<Integer> temp, int K) {
        if(root==null) {
           
            return;
        }
 temp.add(root.val);
         if(root.left==null && root.right==null && root.val==K){
            // temp.add(root.val);
                ans.add(new ArrayList<>(temp));
         }
            // temp.add(root.val);
            populateNodes(root.left,ans,temp,K-root.val);
            populateNodes(root.right,ans,temp,K-root.val);
            temp.remove(temp.size()-1);
        
    }
}