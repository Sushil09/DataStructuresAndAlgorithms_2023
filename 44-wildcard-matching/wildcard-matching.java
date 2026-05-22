class Solution {
    public boolean isMatch(String s, String p) {
        int[][]dp= new int[p.length()][s.length()];
        for(var e:dp)
            Arrays.fill(e,-1);
        return checkMatch(p.toCharArray(), p.length()-1, s.toCharArray(), s.length()-1,dp);
    }

    private static boolean checkMatch(char[]c1,int idx1, char[]c2,int idx2,int[][]dp) {
        if(idx2<0 && idx1<0){
            return true;
        }
         if(idx1<0 && idx2>=0){
            return false;
        }
        if(idx2<0 && idx1>=0) {
            for(int i=0;i<=idx1;i++){
                if(c1[i]!='*')
                    return false;
            }
            return true;
        }
       
       if(dp[idx1][idx2]!=-1)
            return dp[idx1][idx2]==1?true:false;

        if(c1[idx1]==c2[idx2] || c1[idx1]=='?'){
            boolean result = checkMatch(c1,idx1-1,c2,idx2-1,dp);
             dp[idx1][idx2] = result?1:0;
             return result;
        }
            

        if(c1[idx1]=='*') {
            boolean result = checkMatch(c1,idx1-1,c2,idx2,dp) || checkMatch(c1,idx1,c2,idx2-1,dp);
             dp[idx1][idx2] = result?1:0;
             return result;
        }    
        dp[idx1][idx2]=0;
        return false;
    }
}