class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int row=grid.length;
        int col = grid[0].length;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(grid[i][j] == '1') {
                    islands++;
                    checkNeighbour(grid,i,j,row,col);
                }
            }
        }
        return islands;
    }

    private void checkNeighbour(char[][]grid,int i, int j, int row, int col) {
        if(i>=0 && j>=0 && j<col && i<row && grid[i][j]=='0') {
            return;
        }
            if(isValid(grid,i,j,row,col)) {
                grid[i][j]='0';
                checkNeighbour(grid,i+1,j,row,col);
                checkNeighbour(grid,i-1,j,row,col);
                checkNeighbour(grid,i,j+1,row,col);
                checkNeighbour(grid,i,j-1,row,col);
            }
    }
    private boolean isValid(char[][]grid,int i, int j, int row, int col) {
        return  i>=0 && j>=0 && i<row && j<col && grid[i][j] == '1';
    }
}