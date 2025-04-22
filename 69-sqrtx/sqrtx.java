class Solution {
    public int mySqrt(int x) {
        int l =1,h=x;
        int ans = 0;
        while (l<=h) {
            long mid = l + (h-l)/2;
            if(mid*mid<=x) {
                ans = (int)mid;
                l=(int)mid+1;
            }else
                h=(int)mid-1;
        }
        return ans;
    }
}