class Solution {
    public int minEatingSpeed(int[] piles, int hr) {
        int l= 1;
        int h = Integer.MIN_VALUE;

        for(int a: piles){
            // l=Math.min(l,a);
            h=Math.max(h,a);
        }
        int ans = piles[0];

        while(l<=h) {
            int mid = l+(h-l)/2;
            if(isPossible(piles,hr,mid)){
                ans=mid;
                h=mid-1;
            }else
                l=mid+1;
        }
        return ans;
    }

    private static boolean isPossible(int[]arr, int h, int mid) {
        int hrs = 0;
        for(int i=0;i<arr.length;i++){
          hrs += Math.ceil(arr[i]/(double)mid); 
        }
        return hrs<=h;
    }
}