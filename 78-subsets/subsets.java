class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<>();
        populateSubset(nums,0,new ArrayList<>(),subsetList);
        return subsetList;
    }

    private void populateSubset(int[] nums, int idx, List<Integer> list, List<List<Integer>> subsetList) {
        if(idx == nums.length) {
            subsetList.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[idx]);
        populateSubset(nums,idx+1,list,subsetList);
        list.remove(list.size()-1);
        populateSubset(nums,idx+1,list,subsetList);
    }
}