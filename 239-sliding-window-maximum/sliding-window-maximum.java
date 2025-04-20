class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Integer> maxElements = new ArrayList<>();
        int i = 0, j = 0;

        while (j < nums.length) {
            // Add current element
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // Window size is exactly k
                maxElements.add(map.lastKey());

                // Remove the element going out of the window
                int outElement = nums[i];
                if (map.get(outElement) == 1) {
                    map.remove(outElement);
                } else {
                    map.put(outElement, map.get(outElement) - 1);
                }

                i++;
                j++;
            }
        }

        // Convert to int[]
        int[] ans = new int[maxElements.size()];
        for (int z = 0; z < ans.length; z++) {
            ans[z] = maxElements.get(z);
        }

        return ans;
    }
}
