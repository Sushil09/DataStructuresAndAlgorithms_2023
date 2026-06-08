class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++) {
             maxJump = Math.max(maxJump,nums[i]+i);
            if(maxJump>=nums.length-1)
                return true;
            if(maxJump<=i)
                return false;    
        }
        return false;
    }
}