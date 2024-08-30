class Solution {
    public boolean canJump(int[] nums) {
        int maxTillNow =0;
        for(int i=0;i<nums.length;i++) {
             if(maxTillNow<i) 
                   return false;
            maxTillNow = Math.max(nums[i]+i,maxTillNow);
          
           
        }
        return true;
    }
}