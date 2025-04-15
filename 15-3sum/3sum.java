class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // Set<List<Integer>> set= new HashSet<>();
        int i=0;
        List<List<Integer>> ans = new ArrayList<>();
        while(i<nums.length-2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int j=i+1,k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j] + nums[k] ==0){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                   k--;
                   j++;
                //    set.add(temp);
                   while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
                else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }else
                j++;
            }
            i++;
        }
        
        // for(List list: set)
        //     ans.add(list);
        return ans;    
    }
}