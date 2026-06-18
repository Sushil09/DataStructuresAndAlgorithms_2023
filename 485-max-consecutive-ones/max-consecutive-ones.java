class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0,j=0;
        int maxOnes =0;
        int tempCount = 0;
        while(j<nums.length) {
            if(nums[j]==1){
                tempCount++;
                maxOnes = Math.max(tempCount,maxOnes);
            }else{
                i=j;
                tempCount=0;
            }
            j++;
        }
        return maxOnes;
    }
}