class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)
        return -1;
        int row = grid.length;
        int col = grid[0].length;
        int[]dx = {0,0,-1,1,1,-1,1,-1};
        int[]dy= {1,-1,0,0,-1,1,1,-1};
        int[][] dis = new int[row][col];
        for(var arr: dis)
            Arrays.fill(arr,Integer.MAX_VALUE);

        dis[0][0]=0;    
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0});

        while(!q.isEmpty()) {
            int[] polled = q.poll();
            int x = polled[1];
            int y = polled[2];
            int distance = polled[0];
            for(int i=0;i<8;i++) {
                int newX = dx[i]+x;
                int newY = dy[i]+y;
                if(isPossible(grid,newX,newY) && dis[newX][newY]>distance+1) {
                    dis[newX][newY]=distance+1;
                    q.add(new int[]{distance+1,newX,newY});
                }
            }
        }
        if(dis[row-1][col-1]==Integer.MAX_VALUE) {
            return -1;
        }

        return dis[row-1][col-1]+1;
    }

    private static boolean isPossible(int[][] grid, int x, int y) {
        return x>=0 && y>=0 && x<grid.length && y<grid.length && grid[x][y]==0;
    }
}