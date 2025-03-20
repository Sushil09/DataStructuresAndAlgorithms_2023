class Solution {
    public int minInsertions(String s) {
        int N = s.length();
        String reversedString = new StringBuffer(s).reverse().toString();
        int [][] dp = new int[N+1][N+1];
        
        minInsertionsUtil(s.toCharArray(),reversedString.toCharArray(),N, dp);    
        return N - dp[N][N];
    }

    private static void minInsertionsUtil(char []c1, char[]c2, int N, int[][]dp) {

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(c2[j-1] == c1[i-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
    }


}