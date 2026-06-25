class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int ans = Integer.MIN_VALUE;

        ans = Math.max(nums[0]*nums[1]*nums[nums.length-1],nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);

        return ans;

    }
}


/*

{-25,-10,1,2,3}
[]
*/