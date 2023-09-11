class Solution {
    public int trap(int[] height) {
        int[] preFixes = new int[height.length];
        int[] postFixes = new int[height.length];
        int prefixMax=height[0];
        int postfixMax=height[height.length-1];
        int waterCollected = 0;
        for(int i=0;i<height.length;i++){
            prefixMax=Math.max(height[i],prefixMax);
            preFixes[i]=prefixMax;
        }

         for(int i=height.length-1;i>=0;i--){
            postfixMax=Math.max(height[i],postfixMax);
            postFixes[i]=postfixMax;
        }

        for(int i=0;i<height.length;i++){
            waterCollected+=Math.min(preFixes[i],postFixes[i])-height[i];
        }

        return waterCollected;
    }
}