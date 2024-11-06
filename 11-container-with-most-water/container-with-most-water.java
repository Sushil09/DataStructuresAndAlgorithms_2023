class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int i=0, j= height.length-1;
        while (i<=j) {
            maxWater = Math.max((j-i)*Math.min(height[i],height[j]),maxWater);
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return maxWater;
    }
}