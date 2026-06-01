class Solution {
    public int closedIsland(int[][] grid) {
        int islands = 0;
        for(int i=1;i<grid.length-1;i++) {
            for(int j=1;j<grid[0].length-1;j++) {
                if(grid[i][j]==0){
                    if(surroundedByOnes(i,j,grid))
                        islands++;
                }
            }
        }
        return islands;
    }

    private static boolean surroundedByOnes(int i, int j, int[][]grid) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
            return false;

        if(grid[i][j] == 1 || grid[i][j] == 2)
        return true;

    grid[i][j] = 2;

            // if(grid[i][j]==0){
            //    grid[i][j]=2; 
return surroundedByOnes(i+1,j,grid) & surroundedByOnes(i-1,j,grid)
               & surroundedByOnes(i,j+1,grid) & surroundedByOnes(i,j-1,grid);
           
        //   return false;      
         
    }
}