class Solution {
    public void nextPermutation(int[] nums) {
        int idx=-1;
        int n = nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i+1]>nums[i]){
                idx=i;
                break;
            }
        }
        if(idx==-1){
            reverse(nums,0,n-1);
            return;
        }
            

        int nextEle = nums[n-1];
        for(int i=n-1;i>idx;i--){
            if(nums[i]>nums[idx]){
                nextEle=i; 
                break;
            }
        }
        swap(nums,idx,nextEle);
        reverse(nums,idx+1,n-1);    
    }

    private static void swap(int []arr,int i, int j) {
        int temp =arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static void reverse(int[]arr, int st, int end) {
        int i=st,j=end;
        while(i<=j) {
            swap(arr,i,j);
            i++;
            j--;
        }
    }

}