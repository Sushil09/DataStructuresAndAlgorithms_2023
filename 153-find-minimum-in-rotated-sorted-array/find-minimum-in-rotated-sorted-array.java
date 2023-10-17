class Solution {
    public int findMin(int[] nums) {
        int N = nums.length;
        int pivot = 0 ;
        int low=0,high=nums.length;
        
        while(low<=high){
            int mid= low+ (high-low)/2;
            if(nums[mid]>nums[N-1])
                low=mid+1;
            else{
                pivot = mid;
                high=mid-1;
            }    
        }
        return nums[pivot];
    }
}