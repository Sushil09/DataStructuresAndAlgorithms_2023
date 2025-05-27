class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]=='1') {
                   islands++;
                   dfs(grid,i,j); 
                }
            }
        }
        return islands;
    }

    private static void dfs(char[][]grid,int i, int j) {
        if(grid[i][j]=='0')
            return;

        grid[i][j]='0';

        int[]x={0,0,1,-1};
        int[]y={1,-1,0,0};

        for(int z=0;z<4;z++) {
            int newX = x[z]+i;
            int newY = y[z]+j;

            if(newX>=0 && newY>=0 && newX<grid.length && newY<grid[0].length && grid[newX][newY] == '1'){
                 dfs(grid,newX,newY);
            }
        }    
    }
}