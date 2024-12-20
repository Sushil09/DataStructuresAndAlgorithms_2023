class Solution {
    public int lengthOfLongestSubstring(String s) {
        char []c = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int i=0,j=0;
        int ans = 0;
        while(j<s.length()) {
            if(set.contains(c[j])){
                while(set.contains(c[j])){
                    set.remove(c[i]);
                    i++;
                }
            }
        set.add(c[j]);
        ans= Math.max(ans,set.size());
        j++;
    }
            return ans;
}
}