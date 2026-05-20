class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int idx1=text1.length(), idx2= text2.length();
        int[][]dp=new int[idx1][idx2];
        for(int[]arr:dp)
            Arrays.fill(arr,-1);
        return LCS(text1.toCharArray(),idx1-1,text2.toCharArray(),idx2-1,dp);
    }

    private static int LCS(char[]c1, int idx1, char[]c2,int idx2,int[][]dp) {
        if(idx1<0 || idx2<0)
            return 0;
        if(dp[idx1][idx2]!=-1)
            return dp[idx1][idx2];   
        if(c1[idx1]==c2[idx2])
            return 1+LCS(c1,idx1-1,c2,idx2-1,dp);
        return dp[idx1][idx2]=Math.max(LCS(c1,idx1-1,c2,idx2,dp),LCS(c1,idx1,c2,idx2-1,dp));        
    }
}