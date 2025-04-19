class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subset(nums,ans,0,new ArrayList<>());
        return ans;
    }

    private static void subset(int[] nums, List<List<Integer>> ans, int idx,List<Integer> temp) {
        if(idx == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        subset(nums,ans,idx+1,temp);
        temp.remove(temp.size()-1);
        subset(nums,ans,idx+1,temp);


    }
}