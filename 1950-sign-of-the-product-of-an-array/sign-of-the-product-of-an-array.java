class Solution {
    public int arraySign(int[] nums) {
        int countZeros = 0,neg= 0;
        for(int x: nums) {
            if(x==0)
                countZeros++;
            if(x<0)
                neg++;    
        }
        if(countZeros>0)
            return 0;
        if(neg%2 !=0)
            return -1;
        return 1;                
    }
}