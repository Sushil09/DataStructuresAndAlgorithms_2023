class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int i=0,j=height.length-1;
        while(i<j){
            maxWater = Math.max(Math.min(height[i],height[j]) * (j-i), maxWater);
            if(height[i]>height[j])
                j--;
            else
                i++;    
        }
        return maxWater;
    }
}