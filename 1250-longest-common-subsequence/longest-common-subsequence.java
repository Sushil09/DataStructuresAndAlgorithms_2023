class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       int M = text1.length();
       int N = text2.length();
       int [][] dp = new int[M+1][N+1];
       
       for(int[]x:dp)
        Arrays.fill(x,-1);

       int tenp= maxLCS(text1.toCharArray(), text2.toCharArray(),M,N,dp); 
        return dp[M][N];
    }

    int maxLCS(char[]c1,char[]c2,int idx1,int idx2,int[][]dp) {
        if(idx1<=0 || idx2<=0)
            return 0;

        if(dp[idx1][idx2]!=-1)
            return dp[idx1][idx2];

        if(c1[idx1-1]==c2[idx2-1])
            return dp[idx1][idx2] = maxLCS(c1,c2,idx1-1,idx2-1,dp)+1;
        else    
            return dp[idx1][idx2] = Math.max(maxLCS(c1,c2,idx1-1,idx2,dp),maxLCS(c1,c2,idx1,idx2-1,dp));
    }
}