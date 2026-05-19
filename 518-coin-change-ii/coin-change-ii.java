class Solution {
    public int change(int amount, int[] coins) {
        int N = coins.length;
        int[][]dp = new int[N][amount+1];
        for(int[]arr:dp)
            Arrays.fill(arr,-1);
        return combo(amount,coins,N-1,dp);
    }

    private static int combo(int K, int[]coins, int N,int[][]dp) {
        if(N<0 || K<0)
          return 0;

        if(N==0) {
          if(K%coins[N]==0) {
            return 1;
          }
          return 0;
        }  
        if(dp[N][K]!=-1)
            return dp[N][K];

        int pick =0, notPick=0;      
        if(coins[N]<=K) {
            pick = combo(K-coins[N],coins,N,dp);
        }
        notPick = combo(K,coins,N-1,dp);
        return dp[N][K]=pick + notPick;   
    }
}