class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int N= arr.length;
        Arrays.sort(arr);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<arr.length-2;i++){
            int first = arr[i];
            int j=i+1, k = N-1;
            while(j<N-1 && k>j){
                int second=arr[j];
                int third=arr[k];
                if(first+second+third==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(second);
                    list.add(third);
                    set.add(list);
                    j++;
                    k--;
                }else if(first+second+third>0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        ans.addAll(set);
        return ans;        
    }
}