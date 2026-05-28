class Solution {
    public int search(int[] nums, int target) {
        int idx = -1;
        int l=0,h=nums.length-1;
        while(l<=h) {
            int mid = l+(h-l)/2;
            if(nums[mid]==target){
                idx = mid;
                break;
            }else if(nums[mid]<target){
                l=mid+1;
            }else
                h=mid-1;
        }
        return idx;
    }
}