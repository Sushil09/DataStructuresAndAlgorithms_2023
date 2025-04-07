class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int countLCS = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String word: words)
            map.put(word,map.getOrDefault(word,0)+1);
        for(String str: map.keySet()) {
            if(isSubsequence(s,str))
                countLCS+=map.get(str);
        }
        return countLCS;
    }
    private static boolean isSubsequence(String s1, String s2) {
        int i=0,j=0;
        int l1 = s1.length() ,l2= s2.length();
        while(i<l1 && j<l2) {
            if(s2.charAt(j) == s1.charAt(i)) 
                j++;
            i++;    
        }
        return j == s2.length();
    }
    
}