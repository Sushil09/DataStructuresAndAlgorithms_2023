class Solution {
    public int closedIsland(int[][] grid) {
        int N = grid.length, M=grid[0].length;
        int islands =0;

       //boundary Traversal
       //Row

       for(int i=0;i<M;i++){
        if(grid[0][i]==0){
            dfs(grid,0,i,N,M);
        }
        if(grid[N-1][i]==0){
            dfs(grid,N-1,i,N,M);
        }
       }

       //column
       for(int i=0;i<N;i++){
        if(grid[i][0]==0){
            dfs(grid,i,0,N,M);
        }
        if(grid[i][M-1]==0){
            dfs(grid,i,M-1,N,M);
        }
       } 

       for(int i=0;i<N;i++) {
        for(int j=0;j<M;j++) {
            if(grid[i][j]==0){
                islands++;
                dfs(grid,i,j,N,M);
            }
        }
       }
        return islands;
    }
    private static void dfs(int[][]grid, int i, int j, int N, int M) {
        if(i<0 || j<0 || i>=N || j>= M || grid[i][j]!=0){
            return;
        }

        grid[i][j]=1;
        
        dfs(grid,i+1,j,N,M);
        dfs(grid,i-1,j,N,M);
        dfs(grid,i,j+1,N,M);
        dfs(grid,i,j-1,N,M);
    }
}