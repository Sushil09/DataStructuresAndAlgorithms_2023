class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    private static void mergeSort(int[]nums,int l, int h) {
        if(l>=h)
            return;
        int mid = l+ (h-l)/2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,h);
        merge(nums,l,mid,h);    
    }

    private static void merge(int[]arr, int l, int mid, int h) {
        int[]temp = new int[h-l+1];
        int k=0,i=l,j=mid+1;
        while(i<=mid && j<=h) {
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=h){
            temp[k++]=arr[j++];
        }
        // int y=0;
        for(int x=l;x<=h;x++){
            arr[x]=temp[x-l];
        }
    }
}