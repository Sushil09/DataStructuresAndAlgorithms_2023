/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
        return node;
        Map<Node, Node> map = new HashMap<>();
        return cloneGraphUtil(node,map);
        // return map.get(root);
    }

    public static Node cloneGraphUtil(Node root, Map<Node, Node> map) {
      
       if(map.containsKey(root)){
        return map.get(root);
       }

       Node node = new Node(root.val);
       map.put(root,node);

       for(Node neighbour: root.neighbors){
        node.neighbors.add(cloneGraphUtil(neighbour,map));
       }

       return node;
    }

}
