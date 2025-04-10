class Solution {
    public int[] sumPrefixScores(String[] words) {
        int[] ans = new int[words.length];
        
        Trie root = new Trie();
        for(String word: words) 
            constructTrie(word.toCharArray(),root);
        
        for(int i=0;i<words.length;i++) 
            ans[i] = countPrefixes(root,words[i].toCharArray());
        
        return ans;
    }

    private static int countPrefixes(Trie root, char[] word) {
        int ans =0;
        Trie temp = root;
        for(int i=0;i<word.length;i++) {
            int idx = word[i]-'a';
            if(temp.trie[idx]!=null) {
                temp = temp.trie[idx];
                ans+=temp.count;
            }
        }
        return ans;
    }

    private static void constructTrie(char[] word, Trie root) {
        Trie temp = root;
        for(int i=0;i<word.length;i++) {
            int idx = word[i] -'a';
            if(temp.trie[idx] == null) {
                temp.trie[idx] = new Trie();
            }
            temp = temp.trie[idx];
            temp.count++;
        }
        temp.isEOW = true;
    }
}

class Trie {
    Trie[] trie;
    int count;
    boolean isEOW;
    Trie() {
        trie = new Trie[26];
        count = 0;
        isEOW = false;
    }
}