class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0,j=0;
        while(j<nums.length && i<=j) {
            if(nums[i]==nums[j]) {
                j++;
            }else{
                swap(nums,i+1,j);
                i++;
            }
        }
        return i+1; 
    }

    private static void swap(int[]arr,int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=arr[i];
    }
}

/*
0,0,1,1,1,2,2,3,3,4

*/