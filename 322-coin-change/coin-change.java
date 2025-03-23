class Solution {
    public int coinChange(int[] coins, int amount) {
        int M = coins.length;
        int[][]dp = new int[M+1][amount+1];

        for(int i=0;i<=M;i++){
            for(int j=0;j<=amount;j++) 
                    dp[0][j] = Integer.MAX_VALUE/2;
        }

        for(int i=0;i<=M;i++)
            dp[i][0] =0; 

        for(int i=1;i<=M;i++){
            for(int j=1;j<=amount;j++) {
                if(i==1){
                    if(j%coins[i-1]==0)
                        dp[i][j]=j/coins[i-1];
                    else
                        dp[i][j]= Integer.MAX_VALUE/2;    
                }
                if(j>=coins[i-1]) {
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]] +1,dp[i-1][j]);
                }else
                    dp[i][j] =dp[i-1][j];
            }
        }
        return dp[M][amount]==Integer.MAX_VALUE/2?-1:dp[M][amount];    
    }
}