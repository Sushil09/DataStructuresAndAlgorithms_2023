class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[][]dp= new int[N][2];
        for(int[]arr:dp)
            Arrays.fill(arr,-1);
        return maxSellingProfit(prices,0,N,true,dp);
    }

    private static int maxSellingProfit(int[]arr,int idx, int N, boolean canBuy,int[][]dp) {
        if(idx==N)
            return 0;
        int buy = canBuy?1:0;    
        if(dp[idx][buy]!=-1)
            return dp[idx][buy];
        int buyProfit=0,sellProfit =0;
        if(canBuy) {
            buyProfit = Math.max(-arr[idx] + maxSellingProfit(arr,idx+1,N,false,dp),
                                    maxSellingProfit(arr,idx+1,N,true,dp));
        }else{
            sellProfit = Math.max(arr[idx] + maxSellingProfit(arr,idx+1,N,true,dp),
                                    maxSellingProfit(arr,idx+1,N,false,dp));
        }
        return dp[idx][buy]=Math.max(buyProfit,sellProfit);    
    }
}