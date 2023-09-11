class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int[]ans = new int[2];
       int i=0,j=numbers.length-1;
       while(j>0 && i< numbers.length && i<j){
           int numSum = numbers[i]+numbers[j];
           if(numSum==target){
               ans[0]=i+1;
               ans[1]=j+1;
               break;
           }else if(numSum>target){
               j--;
           }else{
               i++;
           }
       }
       return ans;
    }
}