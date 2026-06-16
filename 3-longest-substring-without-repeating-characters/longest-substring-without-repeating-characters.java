class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestSubstring = 0;
        Set<Character> set = new HashSet<>();
        
        int i=0,j=0;
        while(j<s.length() && i<=j) {
            char c = s.charAt(j);
            if(set.contains(c)) {
                while(set.contains(c)){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            set.add(c);
            longestSubstring = Math.max(longestSubstring,j-i+1);
            j++;
        }
        return longestSubstring;
    }
}