class Solution {
    public int search(int[] nums, int target) {
        // int pivot = findPivot(nums);
       return BS(nums,target);

        // return ans;     
    }

    private static int BS(int[] nums, int K) {
    
        int low =0, high = nums.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid]==K)
                return mid;

            //left half is sorted
            if(nums[mid]>=nums[low]) {
                if(nums[mid]>=K && K>=nums[low]){
                    high=mid-1;
                }else
                  low=mid+1;  
            }
            //right half is sorted
            else{
                if(nums[mid]<=K && K<=nums[high]){
                    low=mid+1;  
                }else
                  high=mid-1;
            }
        }
        return -1;
    }
}