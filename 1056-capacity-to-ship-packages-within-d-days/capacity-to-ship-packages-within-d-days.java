class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int totalWeight = sum(weights); 
       int l = max(weights), h =totalWeight;
       int minWeight = l;
       while(l<=h) {
        int mid = l+ (h-l)/2;
            if(isPossible(weights,mid,days)){
                minWeight = mid;
                h = mid-1;
            }else
                l= mid+1;
       }
       return minWeight;
    }

    private boolean isPossible(int[]weights, int weight, int days) {
        int tempWeight = 0, day =1;
        for(int w: weights) {
            
            if(tempWeight+w>weight){
                 tempWeight=0;
                day++;
            }    
            tempWeight+=w;
        }

         return day<=days;
    }

    private int max(int[]weights) {
        int ans = weights[0];
        for(int x: weights)
            ans = Math.max(x,ans);
        return ans;    
    }

    private int sum(int[] weights) {
        int ans = 0;
        for(int x: weights) 
            ans+=x;
        return ans;
    }
}