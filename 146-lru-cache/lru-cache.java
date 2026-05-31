class LRUCache {
    private int size;
    private Node head;
    private Node tail;
    Map<Integer,Node> map;
    
    public LRUCache(int capacity) {
        // Node node = new Node(-1,-1);
        this.size = capacity;
        head= new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        map = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        int value = node.value;
        delete(node);
        insert(node);
        return value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
               Node node = map.get(key);
               node.value=value;
            delete(node);
             insert(node);
             return;
        }
     
        if(this.size==map.size()) {
            Node oldNode = tail.prev;
            map.remove(oldNode.key);
            delete(oldNode);
        }
        Node node = new Node(key, value);

        insert(node);
        map.put(key, node);
        
    }

    private void delete(Node node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void insert(Node node) {
        node.next=head.next;
        head.next.prev=node;
        node.prev=head;
        head.next=node;
    }
    
}

class Node {
    int value;
    int key;
    Node next;
    Node prev;

    Node(int key,int value) {
        this.key=key;
        this.value = value;
        this.next=null;
        this.prev=null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */