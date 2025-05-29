class Solution {
    public int climbStairs(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        int num = ways(n,dp);
        return dp[n];
    }

    private int ways(int n,int []dp) {
        if(n==0)
            return dp[0]=1;
        if(n==1)
            return dp[1]=1;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n] = ways(n-1,dp)+ways(n-2,dp);            

    }
}