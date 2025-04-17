class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, count1 = 0, candidate2=1,count2=0;

        for(int i=0;i<nums.length;i++) {
            if(nums[i] == candidate1) {
                count1++;
            }else if(nums[i] == candidate2){
                count2++;
            }else if(count1==0){
                candidate1=nums[i];
                count1++;
            }else if(count2==0){
                candidate2=nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        
        for(int i=0;i<nums.length;i++){
            if(candidate1==nums[i])
                count1++;
            if(candidate2==nums[i])
                count2++;    
        }

        int threshold = nums.length/3;

        List<Integer> ans = new ArrayList<>();
        if(count1>threshold)
            ans.add(candidate1);
        if(count2>threshold)
            ans.add(candidate2);    
        return ans;    

    }
}

/*


*/