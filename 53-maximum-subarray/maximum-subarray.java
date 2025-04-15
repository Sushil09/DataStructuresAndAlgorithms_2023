class Solution {
    public int maxSubArray(int[] nums) {
       int maxSum = nums[0];       
       int runningSum = nums[0];      

       for(int i=1;i<nums.length;i++) {
        runningSum = Math.max(runningSum+nums[i],nums[i]);
        maxSum = Math.max(maxSum,runningSum);
        // dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
       }
    return maxSum;
    }
}