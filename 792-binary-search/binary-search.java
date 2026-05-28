class Solution {
    public int search(int[] nums, int target) {
        return BS(nums,target,0,nums.length-1);
    }

    private static int BS(int[]arr,int K, int l, int h) {
        if(l>h)
            return -1;
        int mid = l+(h-l)/2;    
        if(arr[mid]==K)
            return mid;
        if(K<arr[mid]) {
            return BS(arr,K,l,mid-1);
        }else{
            return BS(arr,K,mid+1,h);
        }
    }
}