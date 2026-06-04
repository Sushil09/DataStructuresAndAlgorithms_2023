import java.util.Arrays;
class Solution {
    public void sortColors(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int key=nums[i];
            int j=i-1;
            while(j>=0 && nums[j]>key){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=key;
        }
    //    int i=0; int j=0; int k=nums.length-1;
    //    while(j<=k){
    //     if(nums[j]==0){
    //         int temp=nums[i];
    //         nums[i]=nums[j];
    //         nums[j]=temp;
    //         i++;
    //         j++;
    //     }
    //     else if(nums[j]==2){
    //         int temp=nums[j];
    //         nums[j]=nums[k];
    //         nums[k]=temp; 
    //         k--;
    //     }
    //     else{
    //         j++;
    //     }
    //    }
    }
}