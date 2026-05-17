class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        populateCombinations(candidates,candidates.length-1,target,0,ans, new ArrayList<>());
        return ans;
    }

    private static void populateCombinations(int[] arr,int N, int K, int tempSum,List<List<Integer>> ans, List<Integer> ele) {
        if(tempSum==K) {
            ans.add(new ArrayList<>(ele));
            return;
        }

        if(N<0 || tempSum>K)
            return;

        if(tempSum+arr[N]<=K) {
            ele.add(arr[N]);
            populateCombinations(arr,N,K,tempSum+arr[N],ans,ele);
            ele.remove(ele.size()-1);
        }   
        populateCombinations(arr,N-1,K,tempSum,ans,ele);
        
    }
}