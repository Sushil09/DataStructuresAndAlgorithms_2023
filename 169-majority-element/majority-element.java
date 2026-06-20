class Solution {
    public int majorityElement(int[] nums) {
        int temp=0;
        int cnt=0;
        for(int i=0;i<nums.length;i++) {
            if(cnt==0){
                temp=nums[i];
                cnt++;
            } 
            else if(nums[i]==temp)
                cnt++;
            else 
                cnt--;
                   
        }
        return temp;
    }
}