class Solution {
    public int numDistinct(String s, String t) {
        int[][]dp= new int[s.length()][t.length()];
        for(var r : dp)
            Arrays.fill(r,-1);
        return findDistinct(s.toCharArray(),s.length()-1,t.toCharArray(),t.length()-1,dp);
    }

    private static int findDistinct(char []c1, int idx1, char[]c2, int idx2,int[][]dp) {
        if(idx2<0)
            return 1;
        if(idx1<0)
            return 0;

        if(dp[idx1][idx2]!=-1)
            return dp[idx1][idx2];    

        if(c1[idx1]==c2[idx2]) {
            return dp[idx1][idx2]=findDistinct(c1,idx1-1,c2,idx2-1,dp)
                   +findDistinct(c1,idx1-1,c2,idx2,dp);
        }else{
            return dp[idx1][idx2]=findDistinct(c1,idx1-1,c2,idx2,dp);
        }        
    }
}