class Trie {
    private Trie[] trie;
    boolean isEndOfWord;

    public Trie() {
        this.trie = new Trie[26];
        this.isEndOfWord = false;
    }
    
    public void insert(String word) {
        char[] words = word.toCharArray();
        Trie temp =this;
        for (int i=0;i<words.length;i++) {
            if (temp.trie[words[i]-'a'] == null) {
                 temp.trie[words[i]-'a'] = new Trie();   
            }
            temp = temp.trie[words[i]-'a'];
        }
        temp.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        char[] words = word.toCharArray();
        Trie temp = this;
        for (int i=0;i<words.length;i++) {
            if (temp.trie[words[i]-'a'] == null) {
                 return false;   
            }else{
                temp = temp.trie[words[i]-'a'];
            }
        }
        return temp.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        char[] words = prefix.toCharArray();
        Trie temp = this;
        for (int i=0;i<words.length;i++) {
            if (temp.trie[words[i]-'a'] == null) {
                 return false;   
            }else{
                temp = temp.trie[words[i]-'a'];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */