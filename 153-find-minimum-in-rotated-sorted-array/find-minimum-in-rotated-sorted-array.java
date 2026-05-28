class Solution {
    public int findMin(int[] a) {
        int min = Integer.MAX_VALUE;
        int l=0,h=a.length-1;

        while(l<=h) {
            int mid = l+(h-l)/2;
            //left part is sorted
            if(a[mid]>=a[l]){
                min=Math.min(min,a[l]);
                l=mid+1;
            }else{
                min=Math.min(min,a[mid]);
                h=mid-1;
            }
        }
        return min;
    }
}