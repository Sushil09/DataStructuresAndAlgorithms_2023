class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        long maxSum = 0, tempSum = 0;

        while (j < nums.length) {
            tempSum += nums[j];

            // If duplicate exists, shrink window from the left
            while (set.contains(nums[j])) {
                tempSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            set.add(nums[j]);

            // Check if the current window has size k
            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, tempSum);

                // Slide the window
                tempSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            j++;
        }
        return maxSum;
    }
}
