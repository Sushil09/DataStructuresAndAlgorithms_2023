class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount =0;

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==2) {
                    queue.add(new int[]{i,j});
                }
                if(grid[i][j]==1)
                  freshCount++;
            }
        }
    if(queue.isEmpty()) {
        if(freshCount>0)
            return -1;
        else
            return 0;    
        }

        int[]dx= {0,0,1,-1};
        int[]dy= {1,-1,0,0};

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int x = queue.peek()[0];
                int y = queue.poll()[1];
                for(int k=0;k<4;k++) {
                    int X = x+dx[k];
                    int Y = y+dy[k];
                    if(isFresh(X,Y,grid,grid.length,grid[0].length)) {
                        grid[X][Y]=2;
                        queue.add(new int[]{X,Y});
                    }
                }
            }
            minutes++;
        }

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    return -1;
                }
            }
        }
        return minutes-1;
    }

    private static boolean isFresh(int i, int j, int[][]grid,int N, int M) {
        return i>=0 && j>=0 && i<N && j<M && grid[i][j]==1;
    }
}
