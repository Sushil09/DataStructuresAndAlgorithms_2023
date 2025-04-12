class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[][]dp = new int[row][col];

        int ans = 1;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                ans = Math.max(ans,dfs(matrix,i,j,dp));
            }
        }
        return ans;
    }

    private static int dfs(int[][]arr, int i, int j, int[][]dp) {
        if(dp[i][j]!=0)
            return dp[i][j];

        int[]dx = {0,0,-1,1};
        int[]dy = {1,-1,0,0};

        int max =1;
        for(int k=0;k<4;k++) {
            if(isValid(arr,i,j,i+dx[k],j+dy[k])){
                max = Math.max(max,1+dfs(arr,i+dx[k],j+dy[k],dp));
            }
        }

        return dp[i][j]=max;    
    }

    private static boolean isValid(int[][]arr, int i, int j, int newX,int newY) {
        return newX>=0 && newY>=0 && newX<arr.length && newY<arr[0].length && arr[newX][newY]>arr[i][j];
    }
}