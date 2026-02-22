class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        while(j<s.length() && i<=j) {
            char c= s.charAt(j);
            if(set.contains(c)) {
                while(i<=j && set.contains(c)){
                    set.remove(s.charAt(i));
                    i++;
                }            
            }
                set.add(c);
                j++;
            maxLength = Math.max(maxLength,set.size());
        }
        return maxLength;
    }
}