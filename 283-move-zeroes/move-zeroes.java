class Solution {
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        while(j<nums.length && i<=j) {
            if(nums[j]!=0) {
                swap(nums,i,j);
                i++;
            }
            j++;
        }
    }
    private static void swap(int[]arr,int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}