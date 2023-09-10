class Solution {
    public int lengthOfLongestSubstring(String s) {
        int N = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i=0, j=0;
        while(j<N && i<N){
            char each = s.charAt(j);
            if(!set.contains(each)){
                set.add(each);
                j++;
                ans = Math.max(ans,set.size());
            }else{
                while(i<j && set.contains(each)){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
        }
        return ans;
    }
}