class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        int i=0;
        while(i<nums.length-2){
            int first = nums[i];
            int j=i+1,k=nums.length-1;
            while(j<nums.length-1 && j<k){
                int second = nums[j];
                int third = nums[k];
                if(first+second+third==0){
                     List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    j++;
                    k--;
                    set.add(list);
                }else if(first+second+third>0){
                    k--;
                }else{
                    j++;
                }
            }
            i++;
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(set);
        return ans;
    }
}