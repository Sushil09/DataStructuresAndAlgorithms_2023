class Solution {
    public int rob(int[] nums) {
        int N =nums.length;
        int[]dp = new int[N];
        Arrays.fill(dp,-1);
        int tempSum = calcMaxSum(nums,dp,N-1);
        return Arrays.stream(dp)
                        .max()
                        .getAsInt();
    }

    private static int calcMaxSum(int[]arr, int[]dp,int N) {
        if(N==0 )
            return dp[N]=arr[N];
        if(N<0)
            return 0;    
        if(dp[N]!=-1)
            return dp[N];
        int taken = arr[N] + calcMaxSum(arr,dp,N-2);
        int notTaken = calcMaxSum(arr,dp,N-1);

        return dp[N]=Math.max(taken,notTaken);        
    } 
}