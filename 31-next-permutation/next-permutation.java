class Solution {
    public void nextPermutation(int[] nums) {
       int size = nums.length;
       if(size == 1)
        return ;

      int i=size-2;
      while(i>=0 && nums[i] >= nums[i+1])
        i--;    

      if(i>=0){
        int j=size-1;  
      while(j>=0 && nums[i]>=nums[j]) 
            j--;

         swap(nums,i,j);    
      }  
       
      reverse(nums,i+1);  
    }
    
    private static void swap(int[]arr,int x,int y) {
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }

    private static void reverse(int[] arr, int idx) {
        int i=idx,j=arr.length-1;

        while(i<j) {
            swap(arr,i,j);
            i++;
            j--;
        }
    }
}