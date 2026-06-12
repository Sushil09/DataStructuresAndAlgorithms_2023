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
        pathSumUtil(root,targetSum,ans, new ArrayList<>());
        return ans;
    }

    private static void pathSumUtil(TreeNode root, int K, List<List<Integer>> ans, List<Integer> list) {
        if(root==null) {
            return;
        }
        list.add(root.val);
        if(root.left==null && root.right == null) {
            if(K==root.val) {
                ans.add(new ArrayList<>(list));
            }
        }
        
        pathSumUtil(root.left,K-root.val,ans,list);
        pathSumUtil(root.right,K-root.val,ans,list);
        list.remove(list.size()-1);
    }
}