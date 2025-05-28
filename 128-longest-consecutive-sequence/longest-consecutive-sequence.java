class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int x: nums)
            set.add(x);

        int maxCount = 0, count=0;
        
        for(int x: set) {
            count=0;
        if(!set.contains(x+1))    
        while(set.contains(x--)) {
            count++;
            maxCount = Math.max(maxCount,count);
            }
        }
        
    return maxCount;
    }
}