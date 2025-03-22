class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxNegative = nums[0];
        int maxPositive = nums[0];
        int maxProduct = nums[0];   // Store the maximum result encountered

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];

            // Swap when negative to flip the min and max
            if (temp < 0) {
                int swap = maxPositive;
                maxPositive = maxNegative;
                maxNegative = swap;
            }

            maxPositive = Math.max(temp, maxPositive * temp);
            maxNegative = Math.min(temp, maxNegative * temp);

            // Update the max product encountered so far
            maxProduct = Math.max(maxProduct, maxPositive);
        }

        return maxProduct;
    }
}
