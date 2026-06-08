class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if((long)m*k>bloomDay.length) {
            return -1;
        }    

        int l = Integer.MAX_VALUE/2,h= Integer.MIN_VALUE/2;
        int ans = h;
        for(int day: bloomDay) {
            l = Math.min(day,l);
            h = Math.max(day,h);
        }

        while(l<=h) {
            int mid = l+(h-l)/2;
            if(isPossible(bloomDay,mid,m,k)){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[]arr,int mid, int m, int k) {
        int count=0,flower=0;
        for(int i=0;i<arr.length;i++) {
           
            if(arr[i]<=mid){
                count++;
            }else{
                count=0;
            }
             if(count==k) {
                flower++;
                count=0;
            }
        }
        return flower>=m;
    }
}