class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        // Search in the left half
        int ans = BS(nums, 0, pivot - 1, target);
        if (ans != -1) return ans;

        // Search in the right half
        return BS(nums, pivot, nums.length - 1, target);
    }

    private static int findPivot(int[] nums) {
    int low = 0, high = nums.length - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        // Check if mid is the pivot
        if (mid < high && nums[mid] > nums[mid + 1]) {
            return mid + 1;
        }
        if (mid > low && nums[mid] < nums[mid - 1]) {
            return mid;
        }

        // Decide which half to search
        if (nums[mid] >= nums[low]) {  
            // Pivot is in the right half
            low = mid + 1;
        } else {  
            // Pivot is in the left half
            high = mid - 1;
        }
    }

    return 0;  // No rotation (sorted array)
}


    private int BS(int[] a, int l, int h, int K) {
        if (l > h) return -1;

        int mid = l + (h - l) / 2;

        if (a[mid] == K) return mid;

        if (a[mid] > K) 
            return BS(a, l, mid - 1, K);
        else
            return BS(a, mid + 1, h, K);
    }
}
