class Solution {
    public boolean canJump(int[] nums) {
        int size = nums.length;
        int maxIndx = 0;
        for(int i=0;i<size;i++) {
            if(i>maxIndx)
               return false;   
            int maxRechable = nums[i]+i;
            maxIndx= Math.max(maxIndx,maxRechable);
          
            if(maxIndx>=size-1)
                return true;
             
        }
        return false;
    }
}