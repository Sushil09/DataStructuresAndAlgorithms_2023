class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int low = 0, high=len-1;
        int mid=0;
        while(low<=high){
             mid = low+(high-low)/2;
            if(mid!=len-1 && nums[mid]<nums[mid+1])
                low=mid+1;
            else if(mid!=0 && nums[mid]<nums[mid-1])
                high=mid-1;
            else 
                return mid;        
        }
        return mid;
    }
}