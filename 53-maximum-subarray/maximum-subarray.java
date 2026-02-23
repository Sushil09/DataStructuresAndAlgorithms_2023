class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sumTillNow = nums[0];
        for(int i=1;i<nums.length;i++) {
            sumTillNow = Math.max(nums[i],sumTillNow+nums[i]<0?Math.max(nums[i],sumTillNow+nums[i]): sumTillNow+nums[i]);
            ans = Math.max(ans,sumTillNow);
        }
        return ans;
    }
}