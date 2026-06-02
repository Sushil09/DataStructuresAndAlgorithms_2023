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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        createAdjMap(adjList,root);
        return minTime(adjList,start);
    }

    private static int minTime(Map<Integer,List<Integer>> adjList, int src) {
        int time =0;
        Set<Integer> visited =  new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited.add(src);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int polled = queue.poll();
            for(int neighBour: adjList.get(polled)) {
                if(!visited.contains(neighBour)) {
                    queue.add(neighBour);
                    visited.add(neighBour);
                }
            }
            }
            time++;
        }
        return time-1;
    }

    private static void createAdjMap(Map<Integer,List<Integer>> adjList, TreeNode root) {
    if(root == null)
        return;

    adjList.computeIfAbsent(root.val, k -> new ArrayList<>());

    if(root.left != null){
        adjList.get(root.val).add(root.left.val);
        adjList.computeIfAbsent(root.left.val,k->new ArrayList<>()).add(root.val);
    }

    if(root.right != null){
        adjList.get(root.val).add(root.right.val);
        adjList.computeIfAbsent(root.right.val,k->new ArrayList<>()).add(root.val);
    }

    createAdjMap(adjList, root.left);
    createAdjMap(adjList, root.right);
}   
}
