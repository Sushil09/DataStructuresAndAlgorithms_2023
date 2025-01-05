class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int N = cardPoints.length;
        int windowSize = N - k;
        int totalSum = findSum(cardPoints);
        if(windowSize == 0) 
            return totalSum;
        int maxSum=0;
        int i=0,j=0;
        int tempSum =0;
        while(j<N) {
            tempSum+= cardPoints[j];
           
            if(j-i+1 == windowSize) {
                maxSum = Math.max(maxSum, totalSum- tempSum);
                tempSum-= cardPoints[i];
                i++;
            }
             j++;
        }
        return maxSum;
    }
    private static int findSum(int[] a) {
        int sum= 0;
        for(int x:a){
            sum+=x;
        }
        return sum;
    }
}

