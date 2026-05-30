class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int children = g.length,cookie = s.length;
        int i=0,j=0;
        int ans = 0;
        
        while(i<children && j<cookie) {
              if(g[i]<=s[j]){
                ans++;
                i++;
                j++;
              }else{
                j++;
              }  
        }
        return ans;
    }
}