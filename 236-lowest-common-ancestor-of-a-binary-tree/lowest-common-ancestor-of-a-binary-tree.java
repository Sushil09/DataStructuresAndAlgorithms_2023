class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root, p, q);
    }

    private TreeNode LCA(TreeNode root, TreeNode p1, TreeNode p2) {
        if (root == null || root == p1 || root == p2)
            return root;

        TreeNode left = LCA(root.left, p1, p2);
        TreeNode right = LCA(root.right, p1, p2);

        if (left != null && right != null)
            return root;

        return (left != null) ? left : right;
    }
}
