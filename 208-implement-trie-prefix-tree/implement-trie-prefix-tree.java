class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp=root;
        for(char c: word.toCharArray()) {
            int idx = c -'a';
            if(temp.trienode[idx]==null){
                temp.trienode[idx] = new TrieNode();
            }
            temp = temp.trienode[idx];
        }
        temp.isEOW=true;
    }
    
    public boolean search(String word) {
        TrieNode temp=root;
        for(char c: word.toCharArray()) {
            int idx = c -'a';
            if(temp.trienode[idx]==null)
                return false;
            temp =  temp.trienode[idx];   
        }
        return temp.isEOW;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp=root;
        for(char c: prefix.toCharArray()) {
            int idx = c -'a';
            if(temp.trienode[idx]==null)
                return false;
            temp =  temp.trienode[idx];    
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] trienode;
    boolean isEOW;

    TrieNode(){
        trienode = new TrieNode[26];
    }
}

/*
*/

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */