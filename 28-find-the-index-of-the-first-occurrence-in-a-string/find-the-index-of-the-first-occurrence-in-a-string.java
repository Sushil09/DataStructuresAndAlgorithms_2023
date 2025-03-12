class Solution {
    public int strStr(String haystack, String needle) {
        int M = haystack.length(), N = needle.length();
        int i=0,j=0;
        while(j<M) {
            if(j-i+1 == N) {
                if(haystack.substring(i,j+1).equals(needle))
                    return i;
            }
            if(j-i+1>N) {
                i++;
            }else{
                j++;
            }
            
        }
        return -1;
    }
}