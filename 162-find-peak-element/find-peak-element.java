class Solution {
    public int findPeakElement(int[] nums) {
        return findPeak(nums);
    }

    private static int findPeak(int[] arr){
        int low=0, high=arr.length-1;
        int mid=0;
        while(low<=high){
            mid= low + (high-low)/2;
            if(mid!=0 && arr[mid]<arr[mid-1])
                high=mid-1;
            else if(mid!=arr.length-1 && arr[mid]<arr[mid+1])
                low=mid+1;
            else
                return mid;        
        }

        return mid;
    }
}