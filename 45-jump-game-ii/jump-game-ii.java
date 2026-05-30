class Solution {
    public int jump(int[] nums) {
        int l=0,r=0;
        int size = nums.length;
        int jumps=0;
       while(r<size-1){
        int maxFromHere=0;
            for(int i=l;i<=r;i++){
                  maxFromHere = Math.max(nums[i]+i,maxFromHere);
            }
            l=r+1;
            r=Math.max(maxFromHere,r);
            jumps++;
        }
        return jumps;
    }
}