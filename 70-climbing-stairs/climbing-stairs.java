class Solution {
    public int climbStairs(int n) {
        int []dp = new int[n+1];
        Arrays.fill(dp,-1);
        int temp =  populateDp(dp,n);
        return dp[n];
    }

    private int populateDp(int[]dp, int n) {
        if(n==0 || n==1)
            return dp[n]=1;
        if(n==2)
            return dp[n]=2;
        if(dp[n] !=-1)
            return dp[n];
        return dp[n]=populateDp(dp,n-1)+populateDp(dp,n-2);           
    }
}