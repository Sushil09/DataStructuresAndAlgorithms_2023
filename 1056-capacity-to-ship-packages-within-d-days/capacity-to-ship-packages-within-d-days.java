class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int l = Arrays.stream(weights).max().getAsInt();
        int h = Arrays.stream(weights).sum();

        int ans = h;

        while(l<=h) {
            int mid = l+(h-l)/2;

            if(isPossible(weights,mid,days)) {
                ans = mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
    }
    return ans;
  }

  private static boolean isPossible(int[] weights,int mid, int days) {
    int weight =0;
    int day =1;
    for(int i=0;i<weights.length;i++) {
        weight+= weights[i];
        if(weight>mid){
            weight=weights[i];
            day++;
        }
    }
    return day<=days;
  }
}


/*
O(range(high-low))
*/