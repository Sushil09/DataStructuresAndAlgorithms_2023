class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    int islands = calcIslandSize(grid,i,j);
                    maxArea = Math.max(maxArea,islands);
                }
            }
        }
        return maxArea;
    }

    private static int calcIslandSize(int[][] grid, int i, int j) {
        if(grid[i][j]==0)
            return 0;
        grid[i][j]=0;
        int area =1;    

        int[]x={0,0,1,-1};
        int[]y={1,-1,0,0};

        for(int z=0;z<4;z++) {
            int newX = i+x[z];
            int newY = j+y[z];
            if(newX>=0 && newY>=0 && newX<grid.length && newY<grid[0].length && grid[newX][newY] == 1) {
                area+= calcIslandSize(grid,newX,newY);
            }
        }
        return area;
    }
}